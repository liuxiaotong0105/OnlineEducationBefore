package com.jk.controller.index;

import com.jk.modelapi.Movie;
import com.jk.service.index.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "getMovie")
    public List<Movie> getMovie(Movie movie){
        List<Movie> list = movieService.MovieList(movie);
        return list;
    }

}
