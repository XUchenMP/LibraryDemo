package com.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.common.ResultCode;
import com.common.ResultVO;
import com.entity.User;
import com.service.UserService;
import com.utils.Encryption;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户相关功能接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResultVO login(User user) {
        user.setPassword(Encryption.encryption(user.getPassword()));
        User loginUser = userService.login(user);
        if (loginUser != null) {
            StpUtil.login(loginUser.getUsername());
            return ResultVO.newInstance(ResultCode.SUCCESS);
        }
        return ResultVO.newFailInstance("1", "用户名或密码有误");
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    @SaCheckLogin
    public ResultVO logout() {
        redisTemplate.delete(StpUtil.getLoginId());
        StpUtil.logout();
        return ResultVO.newInstance(ResultCode.SUCCESS);
    }

}
