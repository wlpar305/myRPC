package com.rpc.myrpc.config;
import com.rpc.myrpc.loadbalancer.LoadBalancerKeys;
import com.rpc.myrpc.serializer.SerializerKeys;
import lombok.Data;
@Data
public class RpcConfig {
    private String name="wlc-rpc";
    private String version="1.0.0";
    private String serverHost="localhost";
    private Integer serverPort=8080;
    private boolean mock = false;
    private String serializer = SerializerKeys.JDK;
    private RegistryConfig registryConfig = new RegistryConfig();
    private String loadBalancer = LoadBalancerKeys.ROUND_ROBIN;
}
