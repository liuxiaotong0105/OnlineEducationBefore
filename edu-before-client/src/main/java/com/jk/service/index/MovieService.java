package com.jk.service.index;

import com.jk.mapper.index.MovieMapper;
import com.jk.modelapi.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNam MovieService
 * @Description TODO
 * @Author 红旗
 * @Date 2018/10/25 20:03
 * Version 1.0
 **/
@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;

    public Movie getMovieById(Integer movieId) {
        return movieMapper.getMovieById(movieId);
    }
}
