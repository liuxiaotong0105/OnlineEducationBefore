package com.jk.modelapi;


public class Video {


    private Integer movieId;

    private String movieName;

    private String moviePicther;

    private String movieUrl;

    private String movieInfo;


    private Integer movieStatus;

    private Integer teacherid;

    private String movieType;

    private Double moviePrice;
    //教师名称
    private String teachername;
    //教师介绍
    private String teacherinfo;
    //教师类型
    private String teachertype;

    private Integer freeStatus;

    private String movieClass;

    public Integer getFreeStatus() {
        return freeStatus;
    }

    public void setFreeStatus(Integer freeStatus) {
        this.freeStatus = freeStatus;
    }

    public String getMovieClass() {
        return movieClass;
    }

    public void setMovieClass(String movieClass) {
        this.movieClass = movieClass;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {

        this.teachername = teachername;
    }

    public String getTeacherinfo() {
        return teacherinfo;
    }

    public void setTeacherinfo(String teacherinfo) {
        this.teacherinfo = teacherinfo;
    }

    public String getTeachertype() {
        return teachertype;
    }

    public void setTeachertype(String teachertype) {
        this.teachertype = teachertype;
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

    public String getMoviePicther() {
        return moviePicther;
    }

    public void setMoviePicther(String moviePicther) {
        this.moviePicther = moviePicther;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public String getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(String movieInfo) {
        this.movieInfo = movieInfo;
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

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Double getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(Double moviePrice) {
        this.moviePrice = moviePrice;
    }
}