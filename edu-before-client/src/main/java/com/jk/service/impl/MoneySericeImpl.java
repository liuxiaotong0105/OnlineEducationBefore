package com.jk.service.impl;

import com.jk.mapper.MoneyMapper;
import com.jk.modelapi.Course;
import com.jk.modelapi.Video;
import com.jk.service.MoneySerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ${赵成林}
 * @Date: 2018/10/22 18:32
 * @Description:
 */
@Service
public class MoneySericeImpl implements MoneySerice {
    @Autowired
    private MoneyMapper moneyMapper;

    @Override
    public Course querycourse(Integer id) {
        return moneyMapper.querycourse(id);
    }

    @Override
    public List<Video> queryvideo(Integer id) {
        return moneyMapper.queryvideo(id);
    }

    @Override
    public List<Course> tobuy(Integer id) {
        List<Course>  course = moneyMapper.tobuy(id);
        return course;
    }

    @Override
    public List<Video> getvideo(Integer id) {
        return moneyMapper.getvideo(id);
    }

    @Override
    public List<Video> tobuycourse(Integer id) {
        return moneyMapper.tobuycourse(id);
    }

    @Override
    public void addcv(Integer courseid, Integer videoid,Integer userid) {
        moneyMapper.addcv(courseid,videoid,userid);
    }

}
