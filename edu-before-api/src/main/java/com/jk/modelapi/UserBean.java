package com.jk.modelapi;

import java.io.Serializable;

/**
 * @Auther: 赵黎明
 * @Date: 2018/10/21 11:10
 * 描述: 用一段话来简述
 */
public class UserBean implements Serializable {

    private Integer id;

    private String  name;

    private String loginname;

    private String password;

    private String phone;

    private String imgVerify;

    private String status;


    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgVerify() {
        return imgVerify;
    }

    public void setImgVerify(String imgVerify) {
        this.imgVerify = imgVerify;
    }
}
