package com.jk.modelapi;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>项目名称：springCloud
 * 类名称：User
 * 类描述：
 * 创建人：刘晓彤
 * 创建时间：2018/10/12  17:55
 * 手机号：18511777907&16619767907
 * 备注：生命不息，车轮不止
 */

public class Ce implements Serializable {

    public String getWw() {
        return ww;
    }

    public void setWw(String ww) {
        this.ww = ww;
    }

    public String getWq() {
        return wq;
    }

    public void setWq(String wq) {
        this.wq = wq;
    }

    public String getQw() {
        return qw;
    }

    public void setQw(String qw) {
        this.qw = qw;
    }

    private String ww;

    private String wq;

    private String qw;


}
