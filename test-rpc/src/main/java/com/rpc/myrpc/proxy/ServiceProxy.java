package com.rpc.myrpc.proxy;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import com.rpc.myrpc.model.RpcRequest;
import com.rpc.myrpc.model.RpcResponse;
import com.rpc.myrpc.serializer.Serializer;
import com.rpc.myrpc.serializer.JdkSerializer;
public class ServiceProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Serializer serializer = new JdkSerializer();
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameterTypes(method.getParameterTypes())
                .args(args)
                .build();
        try{
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            try(HttpResponse httpResponse=HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()){
                byte[]result=httpResponse.bodyBytes();
                RpcResponse rpcResponse=serializer.deserialize(result,RpcResponse.class);
                return rpcResponse.getData();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
