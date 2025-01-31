package com.rpc.provider;

import com.rpc.common.service.UserService;
import com.rpc.myrpc.RpcApplication;
import com.rpc.myrpc.bootstrap.ProviderBootstrap;
import com.rpc.myrpc.config.RegistryConfig;
import com.rpc.myrpc.config.RpcConfig;
import com.rpc.myrpc.model.ServiceMetaInfo;
import com.rpc.myrpc.model.ServiceRegisterInfo;
import com.rpc.myrpc.registry.LocalRegistry;
import com.rpc.myrpc.registry.Registry;
import com.rpc.myrpc.registry.RegistryFactory;
import com.rpc.myrpc.server.HttpServer;
import com.rpc.myrpc.server.VertxHttpServer;
import com.rpc.myrpc.server.tcp.VertxTcpServer;

import java.util.List;

public class ProviderExample {
    public static void main(String[] args) {
        // 要注册的服务
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList = new ArrayList<>();
        ServiceRegisterInfo serviceRegisterInfo = new ServiceRegisterInfo(UserService.class.getName(), UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);

        // 服务提供者初始化
        ProviderBootstrap.init(serviceRegisterInfoList);
    }
}
