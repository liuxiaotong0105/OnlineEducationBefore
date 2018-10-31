package com.jk.controller.index;

import com.jk.modelapi.Movie;
import com.jk.modelapi.UserBean;
import com.jk.service.index.MovieService;
import com.jk.util.UserUtil;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassNam MovieController
 * @Description TODO
 * @Author 红旗
 * @Date 2018/10/25 17:27
 * Version 1.0
 **/
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    private final String APPKEY = "BC-1447217c711a409c930f64d95c62519e";

    @RequestMapping(value = "getMovie")
    public List<Movie> getMovie(Movie movie){
        List<Movie> list = movieService.MovieList(movie);
        return list;
    }

    @RequestMapping("toMovieInfo")
    public ModelAndView toMovieInfo(Movie movie, HttpServletRequest request){
        UserBean user = UserUtil.getUserInfo(request);
        ModelAndView modelAndView = new ModelAndView("movie/movieInfo");
        Movie m = movieService.getMovieById(movie.getMovieId());
        modelAndView.addObject("m",m);
        modelAndView.addObject("u",user);
        return modelAndView;
    }

    @RequestMapping(value = "addDanMu")
    @ResponseBody
    public void add(String msg, String time){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                GoEasy goEasy = new GoEasy(APPKEY);
                //使用goeasy第三方推送服务 向相同频道的其它用户推送消息
                goEasy.publish("DanMu", msg);
                //将弹幕内容和时间保存到数据库
                //DanMu danMu = new DanMu();
                //danMu.setMsg(msg);
            }
        });
        executorService.shutdown();
        //danMu.setCreateTime(time);
        //danMuService.add(danMu);
    }

}
