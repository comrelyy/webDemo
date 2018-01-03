package com.able.re.socketDemo.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-01-03
 */
public class Client {

    public static void main(String[] args) {
        String msg = "Hello Server";
        try{
            Socket socket = new Socket("127.0.0.1",8080);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            pw.println(msg);
            pw.flush();

            String line = br.readLine();
            System.out.println("received from server:"+ line);

            pw.close();
            br.close();
            socket.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
