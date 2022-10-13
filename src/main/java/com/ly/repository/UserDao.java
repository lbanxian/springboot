package com.ly.repository;

import com.ly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @className: UserDao
 * @description:
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
    // 通过用户名uname查找用户
    User findAllByName(String name);
    // 通过用户名uname和密码查找用户
    User findAllByNameAndPassword(String name, String password);
}
