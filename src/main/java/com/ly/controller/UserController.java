package com.ly.controller;

import com.ly.entity.User;
import com.ly.service.UserService;
import com.ly.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @className: userController
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 实现登录控制
     * 这里的@PostMapping("/login")表示处理post请求，路由为/user/login
     * @param uname
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String name,@RequestParam String password) {
        User user = userService.loginService(name, password);
        if (user != null) {
            return Result.success(user, "登录成功!");
        } else {
            return Result.error("123","账号或密码错误");
        }
    }

    /**
     * 实现注册的控制
     */
    @PostMapping("/register")
    public Result<User> registController(@RequestBody User newUser) {
        User user = userService.registService(newUser);
        if (user != null) {
            return Result.success(user, "注册成功！");
        } else {
            return Result.error("456","用户名已存在！");
        }
    }
}
