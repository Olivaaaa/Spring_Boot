package com.waylau.spring.boot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.waylau.spring.boot.thymeleaf.domain.User;
import com.waylau.spring.boot.thymeleaf.repository.UserRepository;

/**
 * 用户控制器.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2017年2月26日
 */
@RestController
@RequestMapping("/users")
public class UserController {
    //查询所有用户列表的方法,模型与视图。ModelAndView是用于controller层前后台数据交互的
    //注入数据接口
    @Autowired
    private UserRepository userRepository;

    private List<User> getUserlist() {
        return userRepository.listUser();
    }

    //请求映射
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.listUser());
        //页面标题
        model.addAttribute("title", "用户管理");
        //第二个参数是模型名称
        return new ModelAndView("users/list", "userModel", model);
    }

    //查看指定用户
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    //获取创建表单用户
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        //新建一个user
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);

    }

    //修改之后重定向到list列表页面
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {

        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRepository.deleteUser(id);

        model.addAttribute("userList", getUserlist());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }

    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }


}
