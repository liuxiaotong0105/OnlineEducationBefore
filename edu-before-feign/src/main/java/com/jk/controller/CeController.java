package com.jk.controller;

import com.jk.modelapi.Ce;
import com.jk.service.CeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <pre>项目名称：springCloud
 * 类名称：UserController
 * 类描述：]
 * 创建人：刘晓彤
 * 创建时间：2018/10/15  9:37
 * 手机号：18511777907&16619767907
 * 备注：生命不息，车轮不止
 */
@Controller
public class CeController {

    @Autowired
   private CeService ceService;

    @RequestMapping(value="queryCe",method = RequestMethod.GET)
    public Ce queryCe(){
        return ceService.queryCe();
    }

    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }

}
