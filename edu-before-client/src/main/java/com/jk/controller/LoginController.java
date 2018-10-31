package com.jk.controller;

import com.jk.modelapi.AdBean;
import com.jk.modelapi.UserBean;
import com.jk.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: 赵黎明
 * @Date: 2018/10/21 11:24
 * 描述: 用一段话来简述
 */
@Controller
@RequestMapping("user")
public class LoginController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("getUserByLoginName")
    @ResponseBody
    public UserBean getUserByLoginName(@RequestBody UserBean userBean){

       UserBean userBean1=userServiceImpl.getUserByLoginName(userBean);

        return userBean1;
    }
    @RequestMapping("getUserphoneName")
    @ResponseBody
    public UserBean getUserphoneName(String phone){
        return userServiceImpl.getUserphoneName(phone);
    }

    @RequestMapping("addUser")
    @ResponseBody
    public Boolean addUser(@RequestBody UserBean userBean){
        try {
            userServiceImpl.addUser(userBean);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping("getAdList")
    @ResponseBody
    public List<AdBean> getAdList(){
        List<AdBean> list = userServiceImpl.getAdList();
        return list;
    }

}
