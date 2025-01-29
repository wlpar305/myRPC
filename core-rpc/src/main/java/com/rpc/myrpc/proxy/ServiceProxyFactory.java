package com.rpc.myrpc.proxy;
import com.rpc.myrpc.proxy.ServiceProxy;

import java.lang.reflect.Proxy;
public class ServiceProxyFactory {
    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }
}
