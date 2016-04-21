package com.personal.netty.protobuf;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ProtoServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        
        Message.MessageBody req = (Message.MessageBody)msg;
        
        System.out.println(req.getTranscode() + ";" + req.getBody());
        
        Message.MessageBody.Builder builder = Message.MessageBody.newBuilder();
        builder.setTranscode(req.getTranscode());
        builder.setBody("I'm ok!");
        ctx.writeAndFlush(builder);
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
