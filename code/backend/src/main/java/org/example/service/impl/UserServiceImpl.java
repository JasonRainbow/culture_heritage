package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.micrometer.common.util.StringUtils;
import org.example.common.ResponseStatusEnum;
import org.example.exception.CustomException;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.pojo.UserPassword;
import org.example.service.UserService;
import org.example.utils.MD5Util;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public Result register(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        validate(user.getUsername(), user.getPassword(), user.getName());
        queryWrapper.eq("username",user.getUsername());
        boolean isExist = userMapper.exists(queryWrapper);
        if(isExist){
            return Result.error(ResponseStatusEnum.USER_ACCOUNT_EXISTED);
        }
        user.setPassword(MD5Util.encrypt(user.getPassword()));
        int rows = userMapper.insert(user);
        if(rows > 0){
            return Result.success();
        }
        return Result.error(ResponseStatusEnum.ERROR);
    }

    @Override
    public Result login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        validate(username, password);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username).eq("password",MD5Util.encrypt(password));
        User res = userMapper.selectOne(queryWrapper);
        if(res != null){
            res.setPassword(null);
            return Result.success(res);
        }
        return Result.error(ResponseStatusEnum.USERNAME_PASSWORD_ERROR);
    }

    @Override
    public Result rPassword(UserPassword userPassword) {
        validate(userPassword.getUsername(), userPassword.getPassword(), userPassword.getRpassword(),1);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userPassword.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if(user==null){
            return Result.error(ResponseStatusEnum.USER_ACCOUNT_NOT_EXIST);
        }
        if(user.getPassword().equals(MD5Util.encrypt(userPassword.getPassword()))){
            if(user.getPassword().equals(MD5Util.encrypt(userPassword.getRpassword()))){
                return Result.success("0","修改密码与原密码一致");
            }
            user.setPassword(MD5Util.encrypt(userPassword.getRpassword()));
            int count = userMapper.update(user,queryWrapper);
            if(count>0){
                return Result.success("0","修改密码成功");
            }else{
                return Result.error(ResponseStatusEnum.UPDATE_USER_PASSWORD_FAILED);
            }
        }
        return Result.error(ResponseStatusEnum.PASSWORD_ERROR);
    }


    public void validate(String username, String password) {
        if (StringUtils.isBlank(username)) {
            // 用户名为空
            throw new CustomException(ResponseStatusEnum.USERNAME_EMPTY);
        }
        if (StringUtils.isBlank(password)) {
            // 密码为空
            throw new CustomException(ResponseStatusEnum.PASSWORD_EMPTY);
        }
    }

    /**
     * 非空校验校验用户名、密码、昵称
     * @param username 用户名
     * @param password 密码
     * @param name 用户昵称
     */
    public void validate(String username, String password, String name) {
        validate(username, password);
        if (StringUtils.isBlank(name)) {
            throw new CustomException(ResponseStatusEnum.NAME_EMPTY);
        }
    }

    public void validate(String username, String password, String rpassword, Integer flag) {
        validate(username, password);
        if(StringUtils.isBlank(rpassword)){
            throw new CustomException(ResponseStatusEnum.UPDATE_PASSWORD_EMPTY);
        }

    }
    public void validate(String username) {
        if(StringUtils.isBlank(username)){
            throw new CustomException(ResponseStatusEnum.NAME_EMPTY);
        }

    }

    @Override
    public Result update(User user) {
        validate(user.getUsername());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        User user1 = userMapper.selectOne(queryWrapper);
        if(user1==null){
            return Result.error(ResponseStatusEnum.USER_ACCOUNT_NOT_EXIST);
        }
        int count = userMapper.update(user,queryWrapper);
        if(count>0){
            return Result.success("0","修改个人信息成功");
        }
        return Result.error(ResponseStatusEnum.ERROR);
    }
}
