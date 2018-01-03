package com.able.re.socketDemo.niosocket;

import javax.xml.ws.handler.Handler;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-01-03
 */
public class NIOServer {

    public static void main(String[] args) {

        try{
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(8080));

            //设置成非阻塞模式
            ssc.configureBlocking(false);
            //为ssc注册selector
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            Handler handler = new Handler(1024);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static class Handler{
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";

        public Handler(){}
        public Handler(int bufferSize){
            this(bufferSize,null);
        }
        public Handler(String localCharset){
            this(-1,localCharset);
        }
        public Handler(int bufferSize,String localCharset){
                this.bufferSize = bufferSize;
                this.localCharset = localCharset;
        }
    }
}
