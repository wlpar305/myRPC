package com.rpc.myrpc.server.tcp;

import io.vertx.core.Handler;
import io.vertx.core.net.NetSocket;

public class TcpServerHandler implements Handler<NetSocket> {

    @Override
    public void handle(NetSocket socket) {
        TcpBufferHandlerWrapper bufferHandlerWrapper = new TcpBufferHandlerWrapper(buffer -> {
        });
        socket.handler(bufferHandlerWrapper);
    }
}