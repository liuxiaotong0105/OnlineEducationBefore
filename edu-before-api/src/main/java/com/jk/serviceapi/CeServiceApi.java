package com.jk.serviceapi;

import com.jk.modelapi.Ce;
<<<<<<< HEAD
=======
import com.jk.modelapi.Movie;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> e1715199ebf80a549510bbccc29ae0f790a98bbe
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

    @RequestMapping(value = "movie/addMovie",method = RequestMethod.POST)
    void addMovie(@RequestBody Movie movie);



}
