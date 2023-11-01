package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name="用户",description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Operation(summary = "注册", description = "用户注册接口")
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        System.out.println(user);
        return userService.register(user);
    }

    @Operation(summary = "登录", description = "用户登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

}
