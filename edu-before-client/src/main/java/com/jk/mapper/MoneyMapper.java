package com.jk.mapper;

import com.jk.modelapi.Course;
import com.jk.modelapi.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: ${赵成林}
 * @Date: 2018/10/23 10:45
 * @Description:
 */
public interface MoneyMapper {
    Course querycourse(Integer id);

    List<Video> queryvideo(Integer id);

    List<Course> tobuy(Integer id);

    List<Video> getvideo(Integer id);

    List<Video> tobuycourse(Integer id);

    void addcv(@Param("courseid") Integer courseid, @Param("videoid") Integer videoid, @Param("userid") Integer userid);

    Video getVideo(Integer id);

    int status(@Param("id") Integer id, @Param("id1") Integer id1, @Param("status") Integer status);
}
