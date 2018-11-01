package com.jk.mapper;

import com.jk.modelapi.Ce;
import com.jk.modelapi.Movie;

import java.util.List;

public interface CeMapper {
    Ce queryCe();

    void addMovie(Movie movie);

    List<Movie> queryMovieSolr();

}
