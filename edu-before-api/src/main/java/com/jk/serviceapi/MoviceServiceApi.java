package com.jk.serviceapi;

import com.jk.modelapi.Movie;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MoviceServiceApi {

    @RequestMapping(value = "/movieList",method = RequestMethod.POST)
    List<Movie> MovieList(@RequestBody Movie movie);

    @RequestMapping(value = "/getMovieById",method = RequestMethod.GET)
    Movie getMovieById(@RequestParam("movieId") Integer movieId);
}
