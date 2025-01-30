package com.rpc.myrpc.config;
import com.rpc.myrpc.serializer.SerializerKeys;
import lombok.Data;
@Data
public class RpcConfig {
    private String name="wlc-rpc";
    private String version="1.0.0";
    private String severHost="localhost";
    private Integer severPort=8080;
    private boolean mock = false;
    private String serializer = SerializerKeys.JDK;
}
