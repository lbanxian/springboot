package com.ly.service;

import com.ly.entity.User;

/**
 * @description:
 * @date: 2022/10/13
 **/

public interface UserService {
    /**
     * 登录业务逻辑
     * @param name 账户名
     * @param password 密码
     * @return
     */
    User loginService(String name,String password);

    /**
     * 注册业务逻辑
     * @param user 要注册的User对象，属性中的主键Uid 要为空，若uid不为空可能会覆盖已存在的user
     * @return
     */
    User registService(User user);
}
