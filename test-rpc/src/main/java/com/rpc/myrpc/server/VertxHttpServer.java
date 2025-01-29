package com.rpc.myrpc.server;

import io.vertx.core.Vertx;

public class VertxHttpServer implements HttpServer {
    public void doStart(int port) {
        Vertx vertx=Vertx.vertx();
        io.vertx.core.http.HttpServer server=vertx.createHttpServer();
        server.requestHandler(requset->{
            System.out.println("Received request:"+requset.method()+" "+requset.uri());
            requset.response()
                    .putHeader("content-type","text/plain")
                    .end("Hello from Vert.x HTTP server!");
        });
        server.listen(port,result->{
            if(result.succeeded()){
                System.out.println("Vert.x HTTP server started on port "+port);
            }else{
                System.out.println("Failed to start server: " + result.cause());
            }
        });
    }
}
