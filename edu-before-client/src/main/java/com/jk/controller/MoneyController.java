package com.jk.controller;

import com.jk.modelapi.Course;
import com.jk.modelapi.Video;


import com.jk.service.MoneySerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: ${赵成林}
 * @Date: 2018/10/22 16:57
 * @Description:
 */
@RestController
@RequestMapping("money")
public class MoneyController {
    @Autowired
    private MoneySerice moneySerice;

    @RequestMapping(value = "querycourse",method = RequestMethod.GET)
    public Course querycourse(Integer id){

        return moneySerice.querycourse(id);
    }

    @RequestMapping(value = "queryvideo",method = RequestMethod.GET)
    public List<Video> queryvideo(Integer id){
        return moneySerice.queryvideo(id);
    }

    @RequestMapping(value = "tobuy",method = RequestMethod.GET)
    public List<Course> tobuy(Integer id){
        List<Course> course=moneySerice.tobuy(id);
        return course;
    }
    @RequestMapping(value = "getvideo",method = RequestMethod.GET)
    public List<Video> getvideo(Integer id){
        return moneySerice.getvideo(id);
    }
    @RequestMapping(value = "tobuycourse",method = RequestMethod.GET)
    public List<Video> tobuycourse(Integer id){
        return moneySerice.tobuycourse(id);
    }
    @RequestMapping(value = "addcv" ,method = RequestMethod.GET)
    public void addcv(Integer courseid,Integer videoid,Integer userid) {
        moneySerice.addcv(courseid, videoid,userid);
    }
}
