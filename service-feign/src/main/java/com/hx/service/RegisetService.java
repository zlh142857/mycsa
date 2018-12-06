package com.hx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eureka-client")
public interface RegisetService {
    @RequestMapping(value="/toRegiset/regisetUser")
    String regisetUser();
}
