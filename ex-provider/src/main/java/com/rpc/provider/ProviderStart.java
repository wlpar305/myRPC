package com.rpc.provider;
import com.rpc.myrpc.bootstrap.ProviderBootstrap;
import com.rpc.myrpc.model.ServiceRegisterInfo;
import com.rpc.common.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class ProviderStart {
    public static void main(String[] args) {
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList = new ArrayList<>();
        ServiceRegisterInfo serviceRegisterInfo = new ServiceRegisterInfo(UserService.class.getName(), UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);
        ProviderBootstrap.init(serviceRegisterInfoList);
    }
}
