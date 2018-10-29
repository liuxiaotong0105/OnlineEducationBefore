package com.jk.mapper.index;

import com.jk.modelapi.Movie;
import org.apache.ibatis.annotations.Select;

public interface MovieMapper {


    @Select(" select * from t_movie where movieId=#{value} ")
    Movie getMovieById(Integer movieId);
}
