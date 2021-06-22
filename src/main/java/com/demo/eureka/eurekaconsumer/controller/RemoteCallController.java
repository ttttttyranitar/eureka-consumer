package com.demo.eureka.eurekaconsumer.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * copyright (C), 2021, Altaria Studio
 *
 * @author Sancho
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * Sancho                  2021/5/19 10:08
 * @program eureka-consumer
 * @description
 * @create 2021/5/19 10:08
 */
@RestController
public class RemoteCallController {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    EurekaClient client;

    @RequestMapping("/hello/{name}")
    public Object helloWithName(@PathVariable(value = "name") String name){

        ServiceInstance instance = lb.choose("helloMS");

        String url="http://"+"localhost:"+instance.getPort()+"/hello";

        System.out.println("uri: "+instance.getUri());

        return restTemplateBuilder.build().getForObject(url+"/{1}",String.class,name);
    }

/*    @RequestMapping("/helloWithMap")
    public Object helloWithNameMap(){

        ServiceInstance instance = lb.choose("helloMS");

        String url="http://"+"localhost:"+instance.getPort()+"/helloWithMap";

        System.out.println("uri: "+instance.getUri());

        Map<String, String> map = Collections.singletonMap("name", "sancho");
        return restTemplateBuilder.build().getForObject(url+"?name={name}",String.class,map);
    }*/

    /**
     *
     *
     * @description 方法存在url npe风险，一般不会这样进行重定向。
     * @params 
     * @return 
     * @author 
     * @date 11:43 2021/5/19
     * 
     */
    /*@GetMapping("/search/{content}")
    public URI search(@PathVariable("content") String content, HttpServletResponse response) throws Exception {

        ServiceInstance instance = lb.choose("helloMS");

        String url="http://"+"localhost:"+instance.getPort()+"/search";

        URI location = restTemplateBuilder.build().postForLocation(url + "/{1}", String.class, content);

        response.sendRedirect(location.toURL().toString());

        return location;
    }*/

}