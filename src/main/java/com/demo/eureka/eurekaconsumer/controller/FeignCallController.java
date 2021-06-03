package com.demo.eureka.eurekaconsumer.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.eureka.eurekaconsumer.entity.Person;
import com.demo.eureka.eurekaconsumer.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

/**
 * copyright (C), 2021, Altaria Studio
 *
 * @author Sancho
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * Sancho                  2021/5/20 13:12                                      使用feign进行远程服务调用的
 * @program eureka-consumer
 * @description 使用feign进行远程服务调用的
 * @create 2021/5/20 13:12
 */

@RestController
public class FeignCallController {

    @Autowired
    FeignService feignService;

    @GetMapping("/feign/hello/{name}")
    public Object helloByName(@PathVariable("name") String name){
        return feignService.helloByName(name);
    }


    @GetMapping("/feign/helloWithMap")
    public Map helloWithMap(){

        Map<String, String> map = Collections.singletonMap("name", "Sancho");
        Map<String, String> res = feignService.helloWithMap(map);
        System.out.println(res);
        return res;
    }


    @GetMapping("/feign/helloByObject/{name}/{id}")
    public String helloByObject(@PathVariable("name")String name,@PathVariable("id") String id){

        Person p=new Person();
        p.setName(name);
        p.setId(id);
        String result = feignService.helloByObject(p);
        Object parse = JSON.parse(result);
        System.out.println(parse);
        return result;
    }
}