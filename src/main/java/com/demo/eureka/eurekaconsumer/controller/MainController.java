package com.demo.eureka.eurekaconsumer.controller;

import com.demo.eureka.eurekaconsumer.feign.service.FeignService;
import com.demo.eureka.eurekaconsumer.feign.service.SidecarFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * copyright (C), 2021, Altaria Studio
 *
 * @author Sancho
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * Sancho                  2021/5/24 11:11
 * @program eureka-consumer
 * @description test ribbon
 * @create 2021/5/24 11:11
 */
@RestController
@RefreshScope
public class MainController {

    @Autowired
    FeignService feignService;

    @Autowired
    SidecarFeign sidecarFeign;

    @Value("${server.port}")
    String port;

  /*  @Value("${version}")
    String version;*/

   /* @Value("${myconfig}")
    String myConfig;*/


/*    @RequestMapping("/version")
    public String getVersion() {

        return version;
    }*/

    @RequestMapping("/isomerism")
    public String getIsomerismCall(){

        return sidecarFeign.isomerismCall();
    }

/*    @RequestMapping("/myConfig")
    public String getMyConfig() {

        return myConfig+" "+version;
    }*/

    @GetMapping("/alive")
    public String alive() {
        return "consumer port:" + port + " " + feignService.alive();
    }
}