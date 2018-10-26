package com.jk.serviceapi;

import com.jk.modelapi.Course;
import com.jk.modelapi.Video;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: ${赵成林}
 * @Date: 2018/10/22 16:27
 * @Description:
 */
public interface MoneyServiceApi {
    @RequestMapping(value = "money/querycourse", method = RequestMethod.GET)
    Course querycourse(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "money/queryvideo", method = RequestMethod.GET)
    List<Video> queryvideo(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "money/tobuy", method = RequestMethod.GET)
    List<Course> tobuy(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "money/getvideo", method = RequestMethod.GET)
    List<Video> getvideo(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "money/tobuycourse", method = RequestMethod.GET)
    List<Video> tobuycourse(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "money/addcv", method = RequestMethod.GET)
    void addcv(@RequestParam(value = "courseid") Integer courseid, @RequestParam(value = "videoid") Integer videoid, @RequestParam(value = "userid") Integer userid);

    @RequestMapping(value = "money/getVideo", method = RequestMethod.GET)
    Video getVideo(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "money/status", method = RequestMethod.GET)
    int status(@RequestParam(value = "id") Integer id, @RequestParam(value = "id1") Integer id1, @RequestParam(value = "status") Integer status);
}
