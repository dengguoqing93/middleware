package org.spiral.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author dengguoqing
 * @date 2019/12/28
 * @copyright spiral
 * @since 1.0 Version
 */
public class NettyDiscardHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("收到消息，丢弃如下");

        while (in.isReadable()) {
            System.out.println((char) in.readByte());
        }

        System.out.println();
    }
}
