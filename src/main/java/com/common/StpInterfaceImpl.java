package com.common;

import cn.dev33.satoken.stp.StpInterface;
import com.entity.UserInfo;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Value("${sa-token.activity-timeout:1800}")
    private Long activityTimeout;

    @Override
    public List<String> getPermissionList(Object loginName, String loginType) {
        UserInfo userInfo;
        if (redisTemplate.hasKey(loginName)) {
            userInfo = (UserInfo) redisTemplate.opsForValue().get(loginName);
        } else {
            userInfo = userMapper.getUserInfo((String) loginName);
            //加入缓存
            redisTemplate.opsForValue().set(loginName, userInfo);
        }
        //设置过期时间，与saToken保持一致
        redisTemplate.expire(loginName, activityTimeout, TimeUnit.SECONDS);
        return userInfo.getAccesses();
    }

    @Override
    public List<String> getRoleList(Object o, String loginType) {
        return null;
    }
}
