package com.hx.service.personnel;/*
 */

import com.hx.Object.MuchObj;
import com.hx.personnel.ClanInfo;
import com.hx.personnel.PersonnelInfo;
import com.hx.personnel.PersonnelRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@FeignClient(value = "eureka-client")
public interface PersonnelInfoService {
    @RequestMapping(value = "/personnelInfoController/personnelList",method = RequestMethod.GET)
    String queryPersonnelList(@RequestParam(value = "page")Integer page,@RequestParam(value = "size") Integer size);
    @PostMapping(value = "/personnelInfoController/insertPer")
    String insertPer(@RequestBody MuchObj muchObj);
    @GetMapping(value = "/personnelInfoController/showImage")
    void showImage(@RequestParam(value = "photoUrl")String photoUrl,@RequestParam(value = "response") HttpServletResponse response);
    @GetMapping(value = "/personnelInfoController/personnelDetail")
    String personnelDetail(@RequestParam(value = "perId")Integer perId);
}
