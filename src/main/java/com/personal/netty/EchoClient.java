package com.personal.netty;

import com.personal.netty.protocol.MsgPackDecoder;
import com.personal.netty.protocol.MsgPactEncoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class EchoClient {

    public void connect(int port){
        
        EventLoopGroup el = new NioEventLoopGroup();
        
        Bootstrap b = new Bootstrap();
        
        b.group(el).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel sc) throws Exception {
                
                sc.pipeline().addLast("msgpack decoder",new MsgPackDecoder());
                sc.pipeline().addLast("msgpack encoder",new MsgPactEncoder());
                sc.pipeline().addLast(new EchoClientHandler());
            }
        });
        
    }
    
    public static void main(String[] args) {
        
        
        

    }

}
