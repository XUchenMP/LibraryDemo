package com.common;

import cn.dev33.satoken.stp.StpInterface;
import com.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<String> getPermissionList(Object loginName, String loginType) {

        return userMapper.getPermissionList((String)loginName);
    }

    @Override
    public List<String> getRoleList(Object o, String loginType) {
        return null;
    }
}
