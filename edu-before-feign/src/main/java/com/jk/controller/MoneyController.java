package com.jk.controller;


import com.alipay.api.AlipayApiException;
import com.jk.modelapi.AlipayBean;
import com.jk.modelapi.Course;
import com.jk.modelapi.Video;
import com.jk.service.MoneyService;
import com.jk.util.AlipayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: ${赵成林}$
 * @Date: 2018/10/19 11:26
 * @Description:
 */
@Controller
@RequestMapping("money")
public class MoneyController {

    @Autowired
   private MoneyService moneyService;


    @RequestMapping("toask")
    public String toask(Model md,Integer id){

        Course course = moneyService.querycourse(id);
        md.addAttribute("course",course);

        List<Video> video = moneyService.queryvideo(course.getId());
        md.addAttribute("video",video);

        for  ( int  i  =   0 ; i  <  video.size()  -   1 ; i ++ )  {
            for  ( int  j  =  video.size()  -   1 ; j  >  i; j -- )  {
                if  (video.get(j).getTeacherid()==(video.get(i).getTeacherid()))  {
                    video.remove(j);
                }
            }
        }
        md.addAttribute("laishi",video);
        return "money/class-details";
    }
    @RequestMapping("tolouvifeo")
    public String tolouvifeo(Model md,Integer id){

        Video Video = moneyService.getVideo(id);
        md.addAttribute("video",Video);


        return "money/class-video";
    }


    @RequestMapping("tobuy")
    public String tobuy(HttpServletRequest request,Model md){
        //request.getSession().getAttribute();获取用户id
        List<Course> course = moneyService.tobuy(1);
        for  ( int  i  =   0 ; i  <  course.size()  -   1 ; i ++ )  {
            for  ( int  j  =  course.size()  -   1 ; j  >  i; j -- )  {
                if  (course.get(j).getId()==(course.get(i).getId()))  {
                    course.remove(j);
                }
            }
        }
        md.addAttribute("course",course);
        return "money/buy";
    }


    @RequestMapping("tovideo")
    public String tovideo(HttpServletRequest request,Model md){
        //request.getSession().getAttribute();获取用户id
        List<Video> video = moneyService.getvideo(1);
        md.addAttribute("video",video);

        return "money/buyVideo";
    }


    @RequestMapping("tobuycourse")
    public String tobuycourse(Integer id,String name,Model md){
        List<Video> video = moneyService.tobuycourse(id);
        md.addAttribute("video",video);
        md.addAttribute("name",name);
        return "money/buycourse";
    }


    @RequestMapping("addcv")
    public String addcv(HttpServletRequest request,Integer id){

        //request.getSession().getAttribute();获取用户id
        //获取视屏套餐id
        Integer idd= (Integer) request.getSession().getAttribute("id");
        Integer status= (Integer) request.getSession().getAttribute("status");
        Integer courseid = null;
        Integer videoid=null;
        if (status==1) {
              courseid = idd;
        }
        if (status==2) {
              videoid = idd;
        }
            moneyService.addcv(courseid,videoid,1);

        return "redirect:tobuy";
    }



    /**
     * out_trade_no 商户订单号，必填
     * subject订单名称，必填
     * total_amount付款金额，必填
     * body商品描述
     * id 课程视屏id
     * @throws
     */
    @RequestMapping("alipay")
    @ResponseBody
    public String alipay(String subject,String total_amount,String body,Integer id,Integer status,HttpServletRequest request) throws AlipayApiException {

            request.getSession().setAttribute("id",id);
            request.getSession().setAttribute("status",status);


        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setBody(body);
        SimpleDateFormat idd=new SimpleDateFormat("yyyyMMddHHmmss");
        String out_trade_no = idd.format(new Date());
        alipayBean.setOut_trade_no(out_trade_no);
        alipayBean.setTotal_amount(new StringBuffer().append(total_amount));
        alipayBean.setSubject(subject);
        return  AlipayUtil.connect(alipayBean);
    }



}
