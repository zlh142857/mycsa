package com.hx.service;/*
 */

import com.hx.Object.MuchObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
public interface DictService {
    @PostMapping(value = "/dict/delDict")
    String delDictById(@RequestParam("id") String id, @RequestBody MuchObj muchObj,@RequestParam("ip") String ip);
}
