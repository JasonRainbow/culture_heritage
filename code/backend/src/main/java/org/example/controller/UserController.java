package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pojo.User;
import org.example.pojo.UserPassword;
import org.example.service.FileService;
import org.example.service.UserService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author yt
 */
@Tag(name="用户",description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private FileService fileService;

    @Operation(summary = "注册", description = "用户注册接口")
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        return userService.register(user);
    }

    @Operation(summary = "登录", description = "用户登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    @Operation(summary = "修改", description = "修改用户信息接口，传用户名和密码，其他修改哪个传哪个，不需要的不传或者设为null")
    @PutMapping("/update")
    public Result update(@RequestBody User user){

        return userService.update(user);
    }

    @Operation(summary = "修改", description = "修改用户密码接口，传用户名、密码和修改后的密码")
    @PutMapping("/rpassword")
    public Result rPassword(@RequestBody UserPassword userPassword){
        return userService.rPassword(userPassword);
    }
    @Operation(summary = "修改", description = "上传并修改用户的头像")
    @PutMapping("/uploadAvatar")
    public Result uploadAvatar(MultipartFile file, Integer id) throws IOException {
        // 保存用户的头像
        String uri = fileService.uploadFile(file);
        User user = userService.getUserById(id);
        user.setAvatar(uri);
        // 保存修改
        userService.update(user);
        return Result.success().put("avatar", uri);
    }
}
