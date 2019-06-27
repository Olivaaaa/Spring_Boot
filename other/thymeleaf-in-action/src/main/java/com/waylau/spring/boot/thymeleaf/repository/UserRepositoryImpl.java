package com.waylau.spring.boot.thymeleaf.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.waylau.spring.boot.thymeleaf.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
    //用户id是唯一的,每增加一个用户，就自动递增，使得每个用户都有唯一一个id
    private static AtomicLong counter = new AtomicLong();
    //用map存储用户信息
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        //如果用户不存在
        if (id == null) {
            //新建id,返回一个递增的id
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);

    }

    @Override
    public User getUserById(Long id) {
        //查询用户，根据id查询，返回id的map对应的user就可以了
        return this.userMap.get(id);
    }

    @Override
    public List<User> listUser() {
        //用ArrayList包装一下
        return new ArrayList<User>(this.userMap.values());
    }
}
