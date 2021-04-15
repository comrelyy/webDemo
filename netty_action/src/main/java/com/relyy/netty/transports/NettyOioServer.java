package com.relyy.netty.transports;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/1/19
 */
public class NettyOioServer {

	public void server(int port)throws Exception{
		final ByteBuf byteBuf = Unpooled.unreleasableBuffer(
				Unpooled.copiedBuffer("Hi!\n\r", Charset.forName("UTF-8"))
		);

		OioEventLoopGroup oioGroup = new OioEventLoopGroup();
		try{
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(oioGroup)
					.channel(OioServerSocketChannel.class)
					.localAddress(new InetSocketAddress(port))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							socketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter(){

								@Override
								public void channelActive(ChannelHandlerContext context){
									context.writeAndFlush(byteBuf.duplicate())
											.addListener(ChannelFutureListener.CLOSE);
								}
							});
						}
					});
			ChannelFuture channelFuture = serverBootstrap.bind().sync();
			channelFuture.channel().closeFuture().sync();
		}finally{
			oioGroup.shutdownGracefully().sync();
		}
	}
}
