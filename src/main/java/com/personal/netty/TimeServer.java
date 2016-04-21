package com.personal.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TimeServer {

    public void bind(int port) {

        //配置io线程组
        //用户接收客户端连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //用于socketchannel网络读写
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            //启动nio服务的辅助启动类   
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel arg0) throws Exception {
                        
                        arg0.pipeline().addLast(new LineBasedFrameDecoder(1024));
                        
                        arg0.pipeline().addLast(new StringDecoder());
                        
                        arg0.pipeline().addLast(new TimeServerHandler());
                    }          
                });
            //绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();
            //等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //释放线程池资源
            bossGroup.shutdownGracefully();

            workGroup.shutdownGracefully();

        }

    }

    public static void main(String[] args) {

        try {

            new TimeServer().bind(8000);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
