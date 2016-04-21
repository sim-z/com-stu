package com.personal.netty.protocol;

import java.util.List;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext ch, ByteBuf buf, List<Object> list) throws Exception {
        
        int length = buf.readableBytes();
        
        byte[] b = new byte[length];
        
        buf.getBytes(buf.readerIndex(), b, 0, length);
        
        MessagePack mp = new MessagePack();
        
        list.add(mp.read(b));
    }

}
