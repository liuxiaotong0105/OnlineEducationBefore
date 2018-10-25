package com.jk.controller;

import com.jk.modelapi.Ce;
import com.jk.modelapi.Movie;
import com.jk.service.CeService;
import com.jk.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

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
    @ResponseBody
    public Ce queryCe(){
        return ceService.queryCe();
    }


    @RequestMapping("toShiPin1")
    public String toShiPin1(){

        return "shiping1";
    }
    @RequestMapping("shangchuan")
    public String shangchuan(){

        return "shangchuan";
    }
    //oss图片上传
    @RequestMapping("initiateMultipartUpload")
    @ResponseBody
    public HashMap<String, Object> headImgUpload(MultipartFile file) throws IOException {

        if (file == null || file.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        //获取文件的大小,单位/KB
        long size = file.getSize();
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrl = ossClient.getImgUrl(name);
        HashMap<String, Object> map=new HashMap<>();
        //文件存储的路径
        map.put("name", imgUrl);
        return map ;
    }
    @RequestMapping("toAddMovie")
    public String toAddMovie(String movieUrl, Model model){
          model.addAttribute("movieUrl",movieUrl);
          return "add";
    }

    @RequestMapping("addMovie")
    @ResponseBody
    public Boolean addMovie(Movie movie){
        try {

            movie.setTeacherid(4);
            ceService.addMovie(movie);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

}
