package com.jk.controller;

import com.jk.modelapi.Ce;
import com.jk.modelapi.Movie;
import com.jk.serviceapi.CeServiceApi;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>项目名称：springCloud
 * 类名称：UserController
 * 类描述：]
 * 创建人：刘晓彤
 * 创建时间：2018/10/15  9:37
 * 手机号：18511777907&16619767907
 * 备注：生命不息，车轮不止
 */
@RestController
public class CeController {

    @Autowired
    private CeServiceApi ceServiceApi;

    @Autowired
    private SolrClient solrClient;

    @RequestMapping(value = "queryCe", method = RequestMethod.GET)
    public Ce queryCe() {

        return ceServiceApi.queryCe();
    }

    @RequestMapping(value = "movie/addMovie", method = RequestMethod.POST)
    public void addMovie(@RequestBody Movie movie) {

        try {
            String price = movie.getMoviePrice();
            if (price == "" || price == null) {
                movie.setMoviePrice("0");
            }
            ceServiceApi.addMovie(movie);
            List<Movie> list = ceServiceApi.queryMovieSolr();
            Movie reMovie = list.get(0);
            movie.setMovieStatus(0);
            SolrInputDocument doc = new SolrInputDocument();

            doc.setField("id", reMovie.getMovieId());
            doc.setField("movie_name", movie.getMovieName());
            doc.setField("free_status", movie.getFreeStatus());
            doc.setField("movie_url", movie.getMovieUrl());
            doc.setField("movie_picther", movie.getMoviePicther());
            doc.setField("movie_info", movie.getMovieInfo());
            doc.setField("movie_status", movie.getMovieStatus());
            doc.setField("movie_type", movie.getMovieType());
            doc.setField("movie_price", movie.getMoviePrice());
            doc.setField("teacher_id", movie.getTeacherid());
            doc.setField("movie_class", movie.getMovieClass());
            doc.setField("teacher_name", movie.getTeacherName());
            solrClient.add("core1", doc);
            solrClient.commit("core1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
