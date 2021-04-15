package com.relyy.jdkdemo.socketDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * 手动实现http协议
 * socket实现数据的传输，http负责对数据接收到的数据进行解析
 * @author cairuirui
 * @create 2018-01-04
 */
public class HttpDemo {

    public static void main(String[] args) {

        try{
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.socket().bind(new InetSocketAddress(8080));

            channel.configureBlocking(false);

            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);

            while (true){
                if (selector.select(3000) == 0){
                    System.out.println("请求超时......");
                    continue;
                }

                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

                while (keyIterator.hasNext()){
                    SelectionKey key = keyIterator.next();
                    new Thread(new HttpHandler(key)).run();
                    keyIterator.remove();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    private static class HttpHandler implements Runnable {

        private int bufferSize = 1024;
        private String localCharset = "UTF-8";
        private SelectionKey selectionKey;

        public HttpHandler(){}
        public HttpHandler(SelectionKey selectionKey){
            this.selectionKey = selectionKey;
        }

        public void handlerAccept() throws IOException{
            SocketChannel clientChennel = ((ServerSocketChannel)selectionKey.channel()).accept();
            clientChennel.configureBlocking(false);
            clientChennel.register(selectionKey.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        public void handlerRead() throws IOException{
            SocketChannel chennel = (SocketChannel) selectionKey.channel();
            ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();

            buffer.clear();

            if (chennel.read(buffer) == -1){
                chennel.close();
            } else {
                buffer.flip();
                String receivedData = Charset.forName(localCharset).newDecoder().decode(buffer).toString();

                //控制台打印报文请求头
                String[] receiveMsg = receivedData.split("\r\n");
                for (String str : receiveMsg){
                    System.out.println(str);
                    if(str.isEmpty()){
                        break;
                    }
                }

                //控制台打印报文请求头
                String[] firstLine = receivedData.split(" ");
                System.out.println();
                System.out.println("Method: \t"+firstLine[0]);
                System.out.println("url : \t"+firstLine[1]);
                System.out.println("HTTP Version: \t"+firstLine[2]);
                System.out.println();

                //返回客户端
                StringBuffer sendMsg = new StringBuffer();
                sendMsg.append("HTTP/1.1 200 OK\r\t");
                sendMsg.append("ContentType:text/html;charset"+localCharset+"\r\n");
                sendMsg.append("\r\n");

                sendMsg.append("<html><head><title></title></head><body>");
                sendMsg.append("接收到的报文是：<br/>");
                for (String str : receiveMsg){
                    sendMsg.append(str + "<br/>");
                }
                sendMsg.append("</body><html>");
                buffer = ByteBuffer.wrap(sendMsg.toString().getBytes(localCharset));
                chennel.write(buffer);
                chennel.close();
            }

        }

        @Override
        public void run() {
            try{
                if (selectionKey.isAcceptable()){
                    handlerAccept();
                }
                if (selectionKey.isReadable()){
                    handlerRead();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
