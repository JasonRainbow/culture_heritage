package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.MD5Util;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public Result<?> register(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        boolean isExist = userMapper.exists(queryWrapper);
        if(isExist){
            return Result.error("-1","用户名已被使用");
        }
        user.setPassword(MD5Util.encrypt(user.getPassword()));
        Integer rows = userMapper.insert(user);
        if(rows>0){
            return Result.success();
        }
        return Result.error("-1","failure");
    }

    @Override
    public Result<?> login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username).eq("password",MD5Util.encrypt(password));
        User res = userMapper.selectOne(queryWrapper);
        if(res != null){
            res.setPassword(null);
            return Result.success(res);
        }
        return Result.error("-1","账号或者密码错误");
    }
}
