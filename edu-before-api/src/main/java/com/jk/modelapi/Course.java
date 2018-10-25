package com.jk.modelapi;

public class Course {
    private Integer id;

    private String courseName;

    private String courseType;

    private Double coursePrice;

    private Integer courseCount;

    private String courseInfo;

    private String courseOninfao;

    private String courseEarnings;

    private Integer videoTeacherid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public Double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Integer getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo == null ? null : courseInfo.trim();
    }

    public String getCourseOninfao() {
        return courseOninfao;
    }

    public void setCourseOninfao(String courseOninfao) {
        this.courseOninfao = courseOninfao == null ? null : courseOninfao.trim();
    }

    public String getCourseEarnings() {
        return courseEarnings;
    }

    public void setCourseEarnings(String courseEarnings) {
        this.courseEarnings = courseEarnings == null ? null : courseEarnings.trim();
    }

    public Integer getVideoTeacherid() {
        return videoTeacherid;
    }

    public void setVideoTeacherid(Integer videoTeacherid) {
        this.videoTeacherid = videoTeacherid;
    }
}