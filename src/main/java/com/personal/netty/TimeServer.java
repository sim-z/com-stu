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

        //����io�߳���
        //�û����տͻ�������
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //����socketchannel�����д
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            //����nio����ĸ���������   
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
            //�󶨶˿ڣ�ͬ���ȴ��ɹ�
            ChannelFuture f = b.bind(port).sync();
            //�ȴ�����˼����˿ڹر�
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //�ͷ��̳߳���Դ
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
