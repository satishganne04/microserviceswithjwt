package com.microservicepractice.controller;

import com.microservicepractice.VO.ResponseTemplateVO;
import com.microservicepractice.entity.User;
import com.microservicepractice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    private User saveUser(@RequestBody User user){
        log.info("inside save user of user controller");
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    private ResponseTemplateVO getUserDepartment(@PathVariable("id") Long userId){
        log.info("insie a templatevo controller class");
        return userService.getUserWithDepartment(userId).block();

    }

}
