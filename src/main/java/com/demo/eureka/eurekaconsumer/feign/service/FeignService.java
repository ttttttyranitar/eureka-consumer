package com.demo.eureka.eurekaconsumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * copyright (C), 2021, Altaria Studio
 *
 * @author Sancho
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * Sancho                  2021/5/20 11:02                                      使用openFeign完成服务远程调用
 * @program eureka-consumer
 * @description 使用openFeign完成服务远程调用
 * @create 2021/5/20 11:02
 */
@FeignClient("helloMS")
public interface FeignService {

    @GetMapping("/hello")
    public Object hello();


    @GetMapping("/hello/{name}")
    public String helloByName(@PathVariable("name") String name);


    @GetMapping ("/helloWithMap")
    public String helloWithMap(@RequestParam Map<String,String> map);
}