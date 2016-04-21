package com.personal.netty.protobuf;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ProtoClientHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        
        for(int i=0;i<100;i++){
            
            Message.MessageBody.Builder builder= Message.MessageBody.newBuilder();
            
            builder.setTranscode(String.valueOf(i));
            
            builder.setBody("how are you ?");
            
            ctx.write(builder);
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        
        Message.MessageBody resp = (Message.MessageBody)msg;
        
        System.out.println(resp.getTranscode() + ";" + resp.getBody());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
    
}
