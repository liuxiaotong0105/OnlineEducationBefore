package com.jk.service;

import com.jk.modelapi.Course;
import com.jk.modelapi.Video;

import java.util.List;

/**
 * @Auther: ${赵成林}
 * @Date: 2018/10/22 18:31
 * @Description:
 */
public interface MoneySerice {


    Course querycourse(Integer id);

    List<Video> queryvideo(Integer id);

    List<Course> tobuy(Integer id);

    List<Video> getvideo(Integer id);

    List<Video> tobuycourse(Integer id);

    void addcv(Integer courseid, Integer videoid,Integer userid);
}
