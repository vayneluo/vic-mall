package com.vic.online.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: vic-mall
 * @Package: com.vic.online.controller
 * @Description: java类作用描述
 * @Author: Vayne.Luo
 * @date 2019/02/21
 */
@RestController
@RequestMapping
public class TestController {

    @GetMapping(value = "/add")
    public String add(){
        System.out.println("success");
        return "添加成功";
    }
}
