package com.jk.controller;

import com.jk.modelapi.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: OnlineEducationBefore
 * @Package: com.jk.controller
 * @类名: EchartsController
 * @java类作用描述: （）
 * @创建者: 温亮
 * @创建时间: 2018/10/23 10:17
 * @更新时间: 2018/10/23 10:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class EchartsController {
    /**
     *
     * @return小学课程
     */
    /**
     * @return数学
     */
    @RequestMapping("shuecharts")
    public String toshuecharts(HttpServletRequest request) {

        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }


        return "/xiao/shuecharts";
    }

    /**
     * @return奥数
     */
    @RequestMapping("aoecharts")
    public String aoecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }

        return "/xiao/aoecharts";
    }

    /**
     * @return英语
     */
    @RequestMapping("yingecharts")
    public String yingecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/xiao/yingecharts";
    }

    /**
     * @return语文
     */
    @RequestMapping("yuecharts")
    public String yuecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/xiao/yuecharts";
    }

    /**
     *
     * @return初中课程
     */
    /**
     * @return语文
     */
    @RequestMapping("cyuecharts")
    public String cyuecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/chu/yuecharts";
    }

    /**
     * @return数学
     */
    @RequestMapping("cshuecharts")
    public String cshuecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/chu/shuecharts";
    }

    /**
     * @return英语
     */
    @RequestMapping("cyingecharts")
    public String cyingecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/chu/yingecharts";
    }

    /**
     * @return物理
     */
    @RequestMapping("cwuecharts")
    public String cwuecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/chu/wuecharts";
    }

    /**
     * @return科学
     */
    @RequestMapping("ckeecharts")
    public String ckeecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/chu/keecharts";
    }

    /**
     * @return化学
     */
    @RequestMapping("chuaecharts")
    public String chuaecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/chu/huaecharts";
    }
    /**
     *
     * @return高中课程
     */
    /**
     * @return语文
     */
    @RequestMapping("gyuecharts")
    public String gyuecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/gao/yuecharts";
    }

    /**
     * @return数学
     */
    @RequestMapping("gshuecharts")
    public String gshuecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/gao/shuecharts";
    }

    /**
     * @return英语
     */
    @RequestMapping("gyingecharts")
    public String gyingecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/gao/yingecharts";
    }

    /**
     * @return物理
     */
    @RequestMapping("gwuecharts")
    public String gwuecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/gao/wuecharts";
    }

    /**
     * @return生物
     */
    @RequestMapping("gshengecharts")
    public String gshengecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/gao/shengecharts";
    }

    /**
     * @return化学
     */
    @RequestMapping("ghuaecharts")
    public String ghuaecharts(HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        return "/gao/huaecharts";
    }
}
