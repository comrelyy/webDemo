package com.relyy.netty.transports;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/1/19
 */
public class NettyNioServer {
	public void server(int port)throws Exception {
		final ByteBuf byteBuf = Unpooled.unreleasableBuffer(
				Unpooled.copiedBuffer("Hi!\n\r", Charset.forName("UTF-8"))
		);

		NioEventLoopGroup group = new NioEventLoopGroup();
		try{
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(group)
					.channel(NioServerSocketChannel.class)
					.localAddress(new InetSocketAddress(port))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							socketChannel.pipeline().addLast(
									new ChannelInboundHandlerAdapter(){
										@Override
										public void channelActive(ChannelHandlerContext ctx) throws Exception{
											ctx.writeAndFlush(byteBuf.duplicate())
													.addListener(ChannelFutureListener.CLOSE);
										}
									}
							);
						}
					});
			ChannelFuture channelFuture = bootstrap.bind().sync();
			channelFuture.channel().closeFuture().sync();
		}finally{
			group.shutdownGracefully().sync();
		}
	}
}
