package com.jk.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.jk.modelapi.UserBean;

/**
 * 获取session用户信息工具类
 */
public class UserUtil {

    /**
     * 获取session用户Bean
     *
     * @param request
     * @return
     */
    public static UserBean getUserInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * 获取session中的用户id
     *
     * @param request
     * @return
     */
    public static int getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        if (user != null) {
            return user.getId();
        } else {
            return -1;
        }
    }
}
