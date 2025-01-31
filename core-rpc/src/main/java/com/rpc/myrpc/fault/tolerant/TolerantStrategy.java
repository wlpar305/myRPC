package com.rpc.myrpc.fault.tolerant;

import com.rpc.myrpc.model.RpcResponse;

import java.util.Map;

public interface TolerantStrategy {
    RpcResponse doTolerant(Map<String, Object> context, Exception e);
}
