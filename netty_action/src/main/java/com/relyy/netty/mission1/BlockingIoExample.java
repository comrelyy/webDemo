package com.relyy.netty.mission1;

import org.springframework.core.io.InputStreamResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/1/18
 */
public class BlockingIoExample {

	public void server(int port) throws IOException{

		ServerSocket serverSocket = new ServerSocket(port);
		Socket clientSocket = serverSocket.accept();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(clientSocket.getInputStream()));

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

		String request,response;
		while ((request = in.readLine()) != null){
			if (Objects.equals("Done",request)){
				break;
			}
			response = processRequest(request);
			out.println(response);
		}
	}

	private String processRequest(String request) {
		return "processed";
	}
}
