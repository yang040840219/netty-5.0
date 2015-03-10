/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.example.basic;

import java.util.concurrent.TimeUnit;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author lilinfeng
 * @date 2014年2月14日
 * @version 1.0
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		ByteBuf buf = (ByteBuf) msg;
//		byte[] req = new byte[buf.readableBytes()];
//		buf.readBytes(req);
//		String body = new String(req, "UTF-8");
        String body = (String)msg ;
		System.out.println("服务端接收到消息 : " + body);

		if("WAIT".equalsIgnoreCase(body)){
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("等待50s 执行。。。。。。") ;
//                    try {
//                        while(true){
//                            TimeUnit.SECONDS.sleep(50000);
//                            break;
//                        }
//                        String currentTime = new java.util.Date(System.currentTimeMillis()).toString();
//                        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
//                        //ctx.writeAndFlush(resp);
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }) ;
//            thread.start();

            while(true){
                            TimeUnit.SECONDS.sleep(10);
                            break;
                        }
            System.out.println("等待20s 执行。。。。。。") ;
            String currentTime = new java.util.Date(System.currentTimeMillis()).toString()+ System.getProperty("line.separator");
            ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
            ctx.writeAndFlush(resp);

		}else{
            System.out.println("立即执行。。。。") ;
            String currentTime = "BAD ORDER" + System.getProperty("line.separator");
            ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
            ctx.writeAndFlush(resp);
		}

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}




    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TimeServerHandler channelActive") ;
        super.channelActive(ctx);
    }
}
