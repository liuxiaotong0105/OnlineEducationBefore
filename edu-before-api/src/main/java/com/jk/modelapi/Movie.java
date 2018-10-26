package com.jk.modelapi;

import java.io.Serializable;

/**
 * <pre>项目名称：OnlineEducationBefore
 * 类名称：Movie
 * 类描述：
 * 创建人：赵佳佳
 * 创建时间：2018/10/23  19:12
 * 修改人：赵佳佳
 * 修改时间：2018/10/23  19:12
 * 备注：大白
 */
public class Movie implements Serializable {

    private Integer movieId;

    private String movieName;

    private String movieUrl;

    private String moviePicther;

    private String movieInfo;

    private String movieType;

    private Integer movieStatus;

    private Integer  teacherid;

    private String moviePrice;

    private String movieClass;

    private String teacherName;

    public String getMovieClass() {
        return movieClass;
    }

    public void setMovieClass(String movieClass) {
        this.movieClass = movieClass;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public String getMoviePicther() {
        return moviePicther;
    }

    public void setMoviePicther(String moviePicther) {
        this.moviePicther = moviePicther;
    }

    public String getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(String movieInfo) {
        this.movieInfo = movieInfo;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Integer getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(Integer movieStatus) {
        this.movieStatus = movieStatus;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(String moviePrice) {
        this.moviePrice = moviePrice;
    }
}
