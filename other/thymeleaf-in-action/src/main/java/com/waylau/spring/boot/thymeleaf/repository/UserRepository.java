/**
 *
 */
package com.waylau.spring.boot.thymeleaf.repository;

import java.util.List;

import com.waylau.spring.boot.thymeleaf.domain.User;

public interface UserRepository {
    //保存用户
    User saveOrUpdateUser(User user);

    //删除用户
    void deleteUser(Long id);

    //查询用户后得到用户列表
    User getUserById(Long id);

    List<User> listUser();
}
