package com.jk.serviceapi;

import com.jk.modelapi.Movie;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface MoviceServiceApi {

    @RequestMapping(value = "/movieList",method = RequestMethod.POST)
    List<Movie> MovieList(@RequestBody Movie movie);
}
