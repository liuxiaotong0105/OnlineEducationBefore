package com.jk.controller.index;

import com.jk.modelapi.Movie;
import com.jk.service.index.MovieService;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassNam MovieController
 * @Description TODO
 * @Author 红旗
 * @Date 2018/10/25 20:00
 * Version 1.0
 **/
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private SolrClient solrClient;

    @RequestMapping(value = "movieList",method = RequestMethod.POST)
    public List<Movie> movieList(@RequestBody Movie movie) throws IOException, SolrServerException {
        List<Movie> movieList = new ArrayList<>();
        SolrQuery params = new SolrQuery();
        StringBuffer search = new StringBuffer("movie_status:1");
        if (StringUtils.isNotEmpty(movie.getMovieName())){
            search.append(" AND movie_name:"+movie.getMovieName());
            if (movie.getFreeStatus() != -1){
                search.append(" AND free_status:"+movie.getFreeStatus());
            }
            if (StringUtils.isNotEmpty(movie.getMovieType())){
                search.append(" AND movie_type:"+movie.getMovieType());
            }
                params.set("q",search.toString());
        }else {
            if (StringUtils.isNotEmpty(movie.getMovieType())){
                search.append(" AND movie_type:"+movie.getMovieType());
            }
            if (movie.getFreeStatus() != -1){
                search.append(" AND free_status:"+movie.getFreeStatus());
            }
            params.set("q",search.toString());
        }


        //暂时不要先测试一波看看
        // params.set("df","movie_name");
        //params.set("fl", "id,solr_name,solr_introduce");
        params.addHighlightField("movie_name");
        //高亮开关
        params.setHighlight(true);
        params.setHighlightSimplePre("<span style='color:red'>");//前缀
        params.setHighlightSimplePost("</span>");//后缀

        QueryResponse query = solrClient.query("core1",params);
        SolrDocumentList results = query.getResults();
        Map<String, Map<String, List<String>>> highlighting = query.getHighlighting();
        for (SolrDocument result: results) {
            Movie m = new Movie();
            String highName = "";
            Map<String, List<String>> map = highlighting.get(result.get("id"));
            List<String> highString = map.get("movie_name");
            if (highString == null){
                try {
                    highName = result.get("movie_name").toString();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                highName = highString.get(0);
            }
            Movie movie1 = movieNode(m, result, highName);
            movieList.add(movie1);
        }

        return movieList;
    }

    private Movie movieNode(Movie m,SolrDocument result,String highName){
        m.setMovieId(Integer.parseInt(result.get("id").toString()));
        m.setMovieInfo(result.get("movie_info").toString());
        m.setMovieName(highName);
        m.setMoviePicther(result.get("movie_picther").toString());
        m.setMoviePrice(result.get("movie_price").toString());
        m.setMovieType(result.get("movie_type").toString());
        m.setMovieClass(result.get("movie_class").toString());
        m.setMovieStatus(Integer.parseInt(result.get("movie_status").toString()));
        m.setMovieUrl(result.get("movie_url").toString());
        m.setTeacherid(Integer.parseInt(result.get("teacher_id").toString()));
        m.setTeacherName(result.get("teacher_name").toString());
        m.setFreeStatus(Integer.parseInt(result.get("free_status").toString()));
        return m;
    }

    @RequestMapping(value = "/getMovieById",method = RequestMethod.GET)
    public Movie getMovieById(@RequestParam("movieId") Integer movieId){
        return movieService.getMovieById(movieId);
    }

}
