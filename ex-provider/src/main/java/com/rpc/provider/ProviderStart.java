package com.rpc.provider;
import com.rpc.myrpc.server.HttpServer;
import com.rpc.myrpc.server.VertxHttpServer;
import com.rpc.myrpc.registry.LocalRegistry;
import com.rpc.common.service.UserService;
public class ProviderStart {
    public static void main(String[] args) {
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
