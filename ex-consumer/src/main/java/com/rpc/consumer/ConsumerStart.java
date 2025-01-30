package com.rpc.consumer;
import com.rpc.common.service.UserService;
import com.rpc.common.model.User;
import com.rpc.myrpc.proxy.ServiceProxyFactory;
public class ConsumerStart {
    public static void main(String[] args) {
        UserService userService=ServiceProxyFactory.getProxy(UserService.class);
        User user=new User();
        user.setName("wlc");
        User newUser=userService.getUser(user);
        if(newUser!=null){
            System.out.println("-----------");
            System.out.println(newUser.getName());
            System.out.println("-----------");
        }else{
            System.out.println("user==null");
        }
    }
}
