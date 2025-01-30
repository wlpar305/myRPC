package com.rpc.myrpc.registry;
import com.rpc.myrpc.model.ServiceMetaInfo;

import java.util.List;
public class RegistryServiceCache {
    List<ServiceMetaInfo> serviceCache;
    void writeCache(List<ServiceMetaInfo> newServiceCache) {
        this.serviceCache = newServiceCache;
    }
    List<ServiceMetaInfo> readCache() {
        return this.serviceCache;
    }
    void clearCache() {
        this.serviceCache = null;
    }
}
