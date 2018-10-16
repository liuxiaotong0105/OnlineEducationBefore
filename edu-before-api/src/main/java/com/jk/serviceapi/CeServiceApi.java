package com.jk.serviceapi;

import com.jk.modelapi.Ce;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <pre>项目名称：springCloud
 * 类名称：UserService
 * 类描述：
 * 创建人：刘晓彤
 * 创建时间：2018/10/12  18:08
 * 手机号：18511777907&16619767907
 * 备注：生命不息，车轮不止
 */
public interface CeServiceApi {

    @RequestMapping(value="queryCe",method = RequestMethod.GET)
    Ce queryCe();





}
