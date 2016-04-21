package com.personal.netty;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeServerHandler extends ChannelHandlerAdapter {
    
    private int counter;
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        
        String body = (String)msg;
        
        System.out.println("receive :" + body + " counter:" + ++counter);
        
        String currentTime = "query time".equals(body)?new Date(System.currentTimeMillis()).toString():"Bad";
        
        currentTime = currentTime + System.getProperty("line.separator");
        
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        
        ctx.writeAndFlush(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        
        ctx.close();
    }

}
