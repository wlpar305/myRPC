package com.rpc.myrpc.server;

import io.vertx.core.Vertx;

public class VertxHttpServer implements HttpServer {
    public void doStart(int port) {
        Vertx vertx=Vertx.vertx();
        io.vertx.core.http.HttpServer server=vertx.createHttpServer();
        server.requestHandler(new HttpServerHandler());
        server.listen(port,result->{
            if(result.succeeded()){
                System.out.println("Vert.x HTTP server started on port "+port);
            }else{
                System.out.println("Failed to start server: " + result.cause());
            }
        });
    }
}
