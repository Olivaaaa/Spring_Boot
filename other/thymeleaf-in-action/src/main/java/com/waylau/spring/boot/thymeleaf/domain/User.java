package com.waylau.spring.boot.thymeleaf.domain;

import javax.xml.bind.annotation.XmlRootElement;

public class User {
    private Long id;
    private String name;
    private String email;

    //构造器
    public User(String waylau, int i) {

    }

    //带参数的构造函数
    public User() {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
