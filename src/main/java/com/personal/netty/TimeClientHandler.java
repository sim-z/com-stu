package com.personal.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeClientHandler extends ChannelHandlerAdapter {
    
    private final byte[] req;
    
    private int counter;
    
    public TimeClientHandler() {
        
        req = ("query time" + System.getProperty("line.separator")).getBytes();
         
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        
        ByteBuf buf = null;
        
        for(int i=0 ;i <100 ;i++){
            
            buf = Unpooled.buffer(req.length);
            
            buf.writeBytes(req);
            
            ctx.writeAndFlush(buf);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        
        String body = (String)msg;
        
        System.out.println("now is " + body + ",counter :" + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        
        System.out.println(cause.getMessage());
        
        ctx.close();
    }
    
    
    
}
