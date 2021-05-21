/**
 * copyright (C), 2021, ImagineAltaria
 *
 * @program eureka-consumer
 * @description
 * @author liuda
 * @create 2021/5/17 9:24
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * liuda         2021/5/17 9:24             1.0
 */

package com.demo.eureka.eurekaconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;



@Configuration
public class RibbonConfig {


    /**
     * 配置客户端远程服务调用方式
     *
     * */
    @Bean
    @LoadBalanced
    public RestTemplate getTemplate(){

        return new RestTemplate();
    }


    /**
     * 配置负载均衡算法，采用轮询方式
     *
     *
     * **/
    @Bean
    public IRule getLoadBalanceRule(){

        return new RoundRobinRule();
    }
}