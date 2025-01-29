package com.rpc.provider;
import com.rpc.common.model.User;
import com.rpc.common.service.UserService;
public class UserServiceImpl implements UserService {
    public User getUser(User user) {
        System.out.println("username:"+user.getName());
        return user;
    }
}
