/**
 *
 */
package com.waylau.spring.boot.thymeleaf.repository;

import java.util.List;

import com.waylau.spring.boot.thymeleaf.domain.User;
import org.springframework.data.repository.CrudRepository;

//Crud已经包含了增删改查的功能
public interface UserRepository extends CrudRepository<User, Long> {
}
