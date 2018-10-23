package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @ProjectName: OnlineEducationBefore
 * @Package: com.jk.controller
 * @类名: EchartsController
 * @java类作用描述:     （）
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
     *
     * @return数学
     */
    @RequestMapping("shuecharts")
    public String toshuecharts(){
        return "/xiao/shuecharts";
    }

    /**
     *
     * @return奥数
     */
    @RequestMapping("aoecharts")
    public String aoecharts(){
        return "/xiao/aoecharts";
    }

    /**
     *
     * @return英语
     */
    @RequestMapping("yingecharts")
    public String yingecharts(){
        return "/xiao/yingecharts";
    }

    /**
     *
     * @return语文
     */
    @RequestMapping("yuecharts")
    public String yuecharts(){
        return "/xiao/yuecharts";
    }

    /**
     *
     * @return初中课程
     */
    /**
     *
     * @return语文
     */
    @RequestMapping("cyuecharts")
    public String cyuecharts(){
        return "/chu/yuecharts";
    }

    /**
     *
     * @return数学
     */
    @RequestMapping("cshuecharts")
    public String cshuecharts(){
        return "/chu/shuecharts";
    }

    /**
     *
     * @return英语
     */
    @RequestMapping("cyingecharts")
    public String cyingecharts(){
        return "/chu/yingecharts";
    }

    /**
     *
     * @return物理
     */
    @RequestMapping("cwuecharts")
    public String cwuecharts(){
        return "/chu/wuecharts";
    }

    /**
     *
     * @return科学
     */
    @RequestMapping("ckeecharts")
    public String ckeecharts(){
        return "/chu/keecharts";
    }

    /**
     *
     * @return化学
     */
    @RequestMapping("chuaecharts")
    public String chuaecharts(){
        return "/chu/huaecharts";
    }
    /**
     *
     * @return高中课程
     */
    /**
     *
     * @return语文
     */
    @RequestMapping("gyuecharts")
    public String gyuecharts(){
        return "/gao/yuecharts";
    }

    /**
     *
     * @return数学
     */
    @RequestMapping("gshuecharts")
    public String gshuecharts(){
        return "/gao/shuecharts";
    }

    /**
     *
     * @return英语
     */
    @RequestMapping("gyingecharts")
    public String gyingecharts(){
        return "/gao/yingecharts";
    }

    /**
     *
     * @return物理
     */
    @RequestMapping("gwuecharts")
    public String gwuecharts(){
        return "/gao/wuecharts";
    }

    /**
     *
     * @return生物
     */
    @RequestMapping("gshengecharts")
    public String gshengecharts(){
        return "/gao/shengecharts";
    }

    /**
     *
     * @return化学
     */
    @RequestMapping("ghuaecharts")
    public String ghuaecharts(){
        return "/gao/huaecharts";
    }
}
