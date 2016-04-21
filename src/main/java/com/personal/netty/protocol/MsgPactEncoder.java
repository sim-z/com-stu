package com.personal.netty.protocol;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MsgPactEncoder extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext ch, Object object, ByteBuf buf) throws Exception {
        
        MessagePack mp = new MessagePack();
        
        byte[] b = mp.write(object);
        
        buf.writeBytes(b);
    }
}
