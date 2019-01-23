package com.hx.service;/*
 */

import com.hx.Object.MuchObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "eureka-client")
public interface SysUserService {
    @GetMapping(value ="/default")
    boolean findByKey(@RequestParam("key")String key,@RequestParam("ip")String ip);
    @GetMapping(value ="/toLogin")
    String toLogin(@RequestParam("key")String key,@RequestParam("ip")String ip);
    @PostMapping(value = "/sysUser/inputUser")
    String inputUser(@RequestBody MuchObj muchObj,@RequestParam("ip") String ip);
}
