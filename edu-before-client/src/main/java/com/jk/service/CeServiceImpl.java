package com.jk.service;

import com.jk.mapper.CeMapper;
import com.jk.modelapi.Ce;
import com.jk.modelapi.Movie;
import com.jk.serviceapi.CeServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>项目名称：springCloud
 * 类名称：UserServiceImpl
 * 类描述：
 * 创建人：刘晓彤
 * 创建时间：2018/10/12  19:05
 * 手机号：18511777907&16619767907
 * 备注：生命不息，车轮不止
 */

@Service
public class CeServiceImpl implements CeServiceApi {

    @Autowired
    private CeMapper ceMapper;

    @Override
    public Ce queryCe() {
        return ceMapper.queryCe();
    }

    @Override
    public void addMovie(Movie movie) {
        String price = movie.getMoviePrice();
        if (price == "" || price == null) {
            movie.setMoviePrice("0");
        }
        ceMapper.addMovie(movie);
    }

    @Override
    public List<Movie> queryMovieSolr() {
        return ceMapper.queryMovieSolr();
    }
}
