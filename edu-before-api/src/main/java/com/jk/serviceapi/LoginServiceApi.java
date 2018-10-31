package com.jk.serviceapi;

import com.jk.modelapi.AdBean;
import com.jk.modelapi.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: 赵黎明
 * @Date: 2018/10/21 11:19
 * 描述: 用一段话来简述
 */
@FeignClient(value = "service-edubefores")
public interface LoginServiceApi {

    @RequestMapping(value = "/user/getUserByLoginName")
    UserBean getUserByLoginName(@RequestBody UserBean userBean);

    @RequestMapping(value = "/user/getUserphoneName")
    UserBean getUserphoneName(@RequestParam(value ="phone") String phone);

    @RequestMapping(value = "/user/addUser",method = RequestMethod.POST)
    void addUser(@RequestBody UserBean userBean);

    @RequestMapping(value = "/user/getAdList")
    List<AdBean> getAdList();
}
