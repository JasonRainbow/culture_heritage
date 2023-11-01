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

    public Result regist(User user){
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
    public Result login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username).eq("password",MD5Util.encrypt(password));
        User user = userMapper.selectOne(queryWrapper);
        user.setPassword(null);
        if(user != null){
            return Result.success(user);
        }
        return Result.error("-1","账号或者密码错误");
    }

    @Override
    public Result update(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        int count = userMapper.update(user,queryWrapper);
        if(count>0){
            return Result.success();
        }
        return Result.error("-1", "修改失败");
    }
}
