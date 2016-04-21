package com.personal.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TimeClient {
    
    public void connect(String host , int port){
        
        EventLoopGroup group = new NioEventLoopGroup();
        
        try {
            Bootstrap b = new Bootstrap();
            
            b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel arg0) throws Exception {
                    //以\n或\r\n作为结束符
                    arg0.pipeline().addLast(new LineBasedFrameDecoder(1024));
                    
                    arg0.pipeline().addLast(new StringDecoder());
                    
                    arg0.pipeline().addLast(new TimeClientHandler());                   
                }            
            });
            //发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();
            
            f.channel().closeFuture().sync();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            
            group.shutdownGracefully();
        }
        
    }
    
    public static void main(String[] args) {
        
        new TimeClient().connect("127.0.0.1", 8000);
        
    }
    
}
