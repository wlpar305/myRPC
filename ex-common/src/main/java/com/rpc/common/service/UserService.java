package com.rpc.common.service;
import com.rpc.common.model.User;
public interface UserService {
    User getUser(User user);
    default short getNumber() {
        return 1;
    }
}
