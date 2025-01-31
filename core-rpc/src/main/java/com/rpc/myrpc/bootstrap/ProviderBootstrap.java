package com.rpc.myrpc.bootstrap;

import com.rpc.myrpc.RpcApplication;
import com.rpc.myrpc.config.RegistryConfig;
import com.rpc.myrpc.config.RpcConfig;
import com.rpc.myrpc.model.ServiceMetaInfo;
import com.rpc.myrpc.model.ServiceRegisterInfo;
import com.rpc.myrpc.registry.LocalRegistry;
import com.rpc.myrpc.registry.Registry;
import com.rpc.myrpc.registry.RegistryFactory;
import com.rpc.myrpc.server.tcp.VertxTcpServer;

import java.util.List;

public class ProviderBootstrap {
    public static void init(List<ServiceRegisterInfo<?>> serviceRegisterInfoList) {
        RpcApplication.init();
        final RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        for (ServiceRegisterInfo<?> serviceRegisterInfo : serviceRegisterInfoList) {
            String serviceName = serviceRegisterInfo.getServiceName();
            LocalRegistry.register(serviceName, serviceRegisterInfo.getImplClass());
            RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
            Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
            serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
            try {
                registry.register(serviceMetaInfo);
            } catch (Exception e) {
                throw new RuntimeException(serviceName + " 服务注册失败", e);
            }
        }
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(rpcConfig.getServerPort());
    }
}
