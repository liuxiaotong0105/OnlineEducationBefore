package com.jk.mapper;

import com.jk.modelapi.UserBean;

/**
 * @Auther: 赵黎明
 * @Date: 2018/10/21 12:07
 * 描述: 用一段话来简述
 */
public interface UserMapper {
    UserBean getUserByLoginName(UserBean userBean);

    UserBean getUserphoneName(String phone);

    void addUser(UserBean userBean);
}
