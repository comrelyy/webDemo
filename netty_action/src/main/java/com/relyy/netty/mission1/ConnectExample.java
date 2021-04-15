package com.relyy.netty.mission1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/1/18
 */
public class ConnectExample {

	private static final Channel channel_from_somewhere = new NioSocketChannel();

	public static void connect(){
		Channel channel = channel_from_somewhere;
		ChannelFuture connect = channel.connect(
				new InetSocketAddress("127.0.0.1", 25));

		connect.addListener(new ChannelFutureListener() {
			@Override
			public void operationComplete(ChannelFuture channelFuture) throws Exception {
				if (channelFuture.isSuccess()) {
					ByteBuf hello = Unpooled.copiedBuffer("hello", Charset.defaultCharset());
					ChannelFuture channelFuture1 = connect.channel().writeAndFlush(hello);
				}else {
					Throwable cause = channelFuture.cause();
					cause.printStackTrace();
				}
			}
		});
	}
}
