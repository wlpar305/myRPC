package com.rpc.provider;

import com.rpc.common.service.UserService;
import com.rpc.myrpc.RpcApplication;
import com.rpc.myrpc.config.RegistryConfig;
import com.rpc.myrpc.config.RpcConfig;
import com.rpc.myrpc.model.ServiceMetaInfo;
import com.rpc.myrpc.registry.LocalRegistry;
import com.rpc.myrpc.registry.Registry;
import com.rpc.myrpc.registry.RegistryFactory;
import com.rpc.myrpc.server.HttpServer;
import com.rpc.myrpc.server.VertxHttpServer;
import com.rpc.myrpc.server.tcp.VertxTcpServer;

public class ProviderExample {
    public static void main(String[] args) {
        RpcApplication.init();
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8080);
    }
}
