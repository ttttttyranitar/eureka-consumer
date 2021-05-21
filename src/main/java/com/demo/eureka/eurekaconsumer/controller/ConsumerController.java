/**
 * copyright (C), 2021, ImagineAltaria
 *
 * @program eureka-consumer
 * @description
 * @author liuda
 * @create 2021/5/13 9:22
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * liuda         2021/5/13 9:22             1.0
 */

package com.demo.eureka.eurekaconsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
@RestController
public class ConsumerController {

    @Autowired
    EurekaClient client;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    LoadBalancerClient lb;



    @GetMapping("/getHelloMS")
    public Object getHelloMs(){
        List<ServiceInstance> instances = client.getInstancesById("helloMS");
        List<URI> uriList = instances.stream().map(instance -> {
            return instance.getUri();
        }).collect(Collectors.toList());

        return uriList ;
    }


    @GetMapping("/hello")
    public String hello(){

        List<InstanceInfo> instances = client.getInstancesByVipAddress("helloMS", false);
        String res="";
        for (InstanceInfo instanceInfo:instances){

            if (InstanceInfo.InstanceStatus.UP==instanceInfo.getStatus()){

                String url="http://"+"localhost:"+instanceInfo.getPort()+"/hello";
                RestTemplate restTemplate = restTemplateBuilder.build();
                res = restTemplate.getForObject(url, String.class);
                break;
            }
        }
        return res;
    }

    @GetMapping("/hello2")
    public String hello2(){

        ServiceInstance instance = lb.choose("helloMS");

        String url="http://"+"localhost:"+instance.getPort()+"/hello";

        return   restTemplateBuilder.build().getForObject(url, String.class);

    }
}