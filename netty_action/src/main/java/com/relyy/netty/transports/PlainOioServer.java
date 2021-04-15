package com.relyy.netty.transports;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/1/19
 */
public class PlainOioServer {

	public void server(int port) throws IOException{
		final ServerSocket serverSocket = new ServerSocket(port);
		try{
			for (;;){
				Socket clientSocket = serverSocket.accept();
				System.out.println("Accepted connection from " + clientSocket);
				new Thread(new Runnable() {
					@Override
					public void run() {
						OutputStream out;
						try{
							 out = clientSocket.getOutputStream();
							 out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
							 out.flush();
							 //clientSocket.close();
						}catch(Exception e){
							e.printStackTrace();
						}finally{
							try{
								clientSocket.close();
							} catch(Exception e){
							    e.printStackTrace();
							}
						}
					}
				}).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
