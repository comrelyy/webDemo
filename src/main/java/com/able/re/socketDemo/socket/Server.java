package com.able.re.socketDemo.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socketDemo
 *
 * @author cairuirui
 * @create 2018-01-03
 */
public class Server {

    public static void main(String[] args) {

        try{
            ServerSocket server = new ServerSocket(8080);
            Socket socket = server.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            System.out.println("received from client: "+line);

            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("received date : " + line);
            pw.flush();
            pw.close();
            br.close();
            socket.close();
            server.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
