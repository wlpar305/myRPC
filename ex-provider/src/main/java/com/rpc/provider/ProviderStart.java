package com.rpc.provider;
import com.rpc.myrpc.server.HttpServer;
import com.rpc.myrpc.server.VertxHttpServer;
import com.rpc.myrpc.registry.LocalRegistry;
import com.rpc.common.service.UserService;
import com.rpc.myrpc.RpcApplication;
public class ProviderStart {
    public static void main(String[] args) {
        RpcApplication.init();
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
