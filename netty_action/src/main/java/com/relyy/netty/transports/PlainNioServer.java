package com.relyy.netty.transports;

import io.netty.channel.ServerChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/1/19
 */
public class PlainNioServer {

	public void server(int port) throws IOException{
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		ServerSocket socket = serverChannel.socket();
		InetSocketAddress socketAddress = new InetSocketAddress(port);
		socket.bind(socketAddress);
		Selector selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes());
		for (;;){
			try{
				selector.select();
			} catch(Exception e){
				e.printStackTrace();
				break;
			}
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				iterator.remove();
				try{
					if(key.isAcceptable()){
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						SocketChannel client = server.accept();
						client.configureBlocking(false);
						client.register(selector,SelectionKey.OP_WRITE | SelectionKey.OP_READ,msg.duplicate());
						System.out.println("Accepted connect from " + client);
						if(key.isWritable()){
							SocketChannel clientChannel = (SocketChannel) key.channel();
							ByteBuffer attachment = (ByteBuffer) key.attachment();
							while (attachment.hasRemaining()){
								if (clientChannel.write(attachment) == 0){
									break;
								}
							}
							client.close();
						}
					}
				} catch(IOException IoE){
					key.cancel();
					try{
						key.channel().close();
					} catch(Exception e){

					}
				}
			}
		}


	}
}
