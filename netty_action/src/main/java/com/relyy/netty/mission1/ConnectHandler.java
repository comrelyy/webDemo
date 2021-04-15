package com.relyy.netty.mission1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/1/18
 */
public class ConnectHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelActive(ChannelHandlerContext ctx){
		System.out.println("Client" + ctx.channel().remoteAddress() +" connected");
	}
}
