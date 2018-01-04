package com.able.re.socketDemo.niosocket;

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

            while (true){
                //等待请求，每次阻塞3s，超过3s后线程继续向下运行
                //如果传0或者不传参数，将会一直阻塞下去
                if (selector.select(3000) == 0){
                    System.out.println("等待请求超时。。。。。。");
                    continue;
                }
                System.out.println("处理请求。。。。。。");
                //获取待处理的selectionKey
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()){
                    SelectionKey key = keyIterator.next();
                    try{
                        if(key.isAcceptable()){
                            handler.handlerAccept(key);
                        }
                        if (key.isReadable()){
                            handler.handlerread(key);
                        }

                    }catch(Exception e){
                        e.printStackTrace();
                        keyIterator.remove();
                        continue;
                    }
                    keyIterator.remove();
                }
            }
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
            if (bufferSize > 1) {
                this.bufferSize = bufferSize;
            }
            if (localCharset != null) {
                this.localCharset = localCharset;
            }
        }

        public void handlerAccept(SelectionKey selectionKey) throws IOException {
            SocketChannel channel =((ServerSocketChannel)selectionKey.channel()).accept();
            channel.configureBlocking(false);
            channel.register(selectionKey.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));

        }

        public void handlerread(SelectionKey selectionKey) throws IOException{
            //获取chennel
            SocketChannel channel =(SocketChannel)selectionKey.channel();
            //重置buffer
            ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
            buffer.clear();
            if (channel.read(buffer) == -1){
                channel.close();
            }else {
                //buffer的状态改为读
                buffer.flip();
                //将buffer中的值按照localCharset的根式存放到receivedStr
                String receivedStr = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
                System.out.println("received from client : "+receivedStr);

                //返回数据给客户端
                String sendStr = "received data :"+receivedStr;
                buffer = ByteBuffer.wrap(sendStr.getBytes(localCharset));
                channel.write(buffer);

                channel.close();
            }

        }
    }
}
