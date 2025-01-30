package com.rpc.myrpc.registry;
import com.rpc.myrpc.config.RegistryConfig;
import com.rpc.myrpc.model.ServiceMetaInfo;

import java.util.List;
public interface Registry {
    void init(RegistryConfig registryConfig);
    void register(ServiceMetaInfo serviceMetaInfo) throws Exception;
    void unRegister(ServiceMetaInfo serviceMetaInfo);
    List<ServiceMetaInfo> serviceDiscovery(String serviceKey);
    void destroy();
    void heartBeat();
    void watch(String serviceNodeKey);
}
