package com.jk.modelapi;

import java.io.Serializable;

/**
 * @Auther: 赵黎明
 * @Date: 2018/10/21 11:10
 * 描述: 用一段话来简述
 */
public class UserBean implements Serializable {

    private String id;

    private String  name;

    private String loginname;

    private String password;

    private String phone;

    private String imgVerify;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
