package com.rpc.myrpc.fault.retry;

import com.rpc.myrpc.model.RpcResponse;

import java.util.concurrent.Callable;

public interface RetryStrategy {
    RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception;
}
