package com.ly.service.serviceImpl;

import com.ly.entity.User;
import com.ly.repository.UserDao;
import com.ly.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @className: UserServiceImpl
 * @description:
 */
@Service
public class UserServiceImpl  implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 实现登录业务逻辑代码
     * @param name    账户名
     * @param password 密码
     * @return
     */
    @Override
    public User loginService(String name, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findAllByNameAndPassword(name,password);
        // 重要信息置空
        if (user != null) {
            user.setPassword("");
        }
        return user;
    }

    /**
     * 实现注册业务逻辑
     * @param user 要注册的User对象，属性中的主键Uid 要为空，若uid不为空可能会覆盖已存在的user
     * @return
     */
    @Override
    public User registService(User user) {
        // 当新用户的用户名已存在时
        if (userDao.findAllByName(user.getName()) != null) {
            // 无法注册
            return null;
        } else {
            // 返回创建好的用户对象（带uid）
            User newUser = userDao.save(user);
            if (newUser != null) {
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}
