package com.rpc.myrpc.loadbalancer;

import com.rpc.myrpc.model.ServiceMetaInfo;

import java.util.List;
import java.util.Map;

public interface LoadBalancer {
    ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList);
}
