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
    @PostMapping("/regist")
    public Result regist(@RequestBody User user){
        System.out.println(user);
        return userService.register(user);
    }

    @Operation(summary = "登录", description = "用户登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    @Operation(summary = "修改", description = "修改用户信息接口，传用户名，其他修改哪个传哪个，不需要传的设为null")
    @PutMapping("/update")
    public Result update(@RequestBody User user){

        return userService.update(user);
    }
}
