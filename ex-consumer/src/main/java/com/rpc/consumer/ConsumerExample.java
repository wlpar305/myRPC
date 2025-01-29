package com.rpc.consumer;
import com.rpc.myrpc.config.RpcConfig;
import com.rpc.myrpc.utils.ConfigUtils;

public class ConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);

    }
}