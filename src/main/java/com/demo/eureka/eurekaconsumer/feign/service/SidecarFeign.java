package com.demo.eureka.eurekaconsumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("sidecar-server")
public interface SidecarFeign {

    @RequestMapping("/isomerismCall")
    public String isomerismCall();
}
