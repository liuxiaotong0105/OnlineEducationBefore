package com.jk.controller;


import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.jk.modelapi.AlipayBean;
import com.jk.modelapi.Course;
import com.jk.modelapi.UserBean;
import com.jk.modelapi.Video;
import com.jk.service.MoneyService;
import com.jk.util.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String, Object> qqProperties = new HashMap<>();

    @RequestMapping("toask")
    public String toask(Model md, Integer id, HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }

        Course course = moneyService.querycourse(id);
        md.addAttribute("course", course);

        List<Video> video = moneyService.queryvideo(course.getId());
        md.addAttribute("video", video);
        for (int i = 0; i < video.size() - 1; i++) {
            for (int j = video.size() - 1; j > i; j--) {
                if (video.get(j).getTeacherid() == (video.get(i).getTeacherid())) {
                    video.remove(j);
                }
            }
        }
        md.addAttribute("laishi", video);
        return "money/class-details";
    }

    @RequestMapping("tolouvifeo")
    public String tolouvifeo(Model md, Integer id, HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
            Integer s = 2;
            int count = moneyService.status(attribute.getId(), id, s);
            md.addAttribute("count", count);
        } else {
            request.setAttribute("status", status);
        }

        Video video = moneyService.getVideo(id);

        md.addAttribute("video", video);


        return "money/class-video";
    }


    @RequestMapping("tobuy")
    public String tobuy(HttpServletRequest request, Model md) {

        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }

        //获取用户id
        UserBean user = (UserBean) request.getSession().getAttribute("user");
        List<Course> course = moneyService.tobuy(user.getId());
        for (int i = 0; i < course.size() - 1; i++) {
            for (int j = course.size() - 1; j > i; j--) {
                if (course.get(j).getId() == (course.get(i).getId())) {
                    course.remove(j);
                }
            }
        }
        md.addAttribute("course", course);
        return "money/buy";
    }


    @RequestMapping("tovideo")
    public String tovideo(HttpServletRequest request, Model md) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        //获取用户id
        UserBean user = (UserBean) request.getSession().getAttribute("user");
        List<Video> video = moneyService.getvideo(user.getId());
        md.addAttribute("video", video);

        return "money/buyVideo";
    }


    @RequestMapping("tobuycourse")
    public String tobuycourse(Integer id, String name, Model md, HttpServletRequest request) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        List<Video> video = moneyService.tobuycourse(id);
        md.addAttribute("video", video);
        md.addAttribute("name", name);
        return "money/buycourse";
    }


    @RequestMapping("addcv")
    public String addcv(HttpServletRequest request, Integer id) {
        String status = "";
        UserBean attribute = (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user", attribute);
            request.setAttribute("status", status);
        } else {
            request.setAttribute("status", status);
        }
        //获取用户id
        UserBean user = (UserBean) request.getSession().getAttribute("user");
        //获取视屏套餐id
        Integer idd = (Integer) request.getSession().getAttribute("id");
        Integer status2 = (Integer) request.getSession().getAttribute("status");
        Integer courseid = null;
        Integer videoid = null;
        if (status2 == 1) {
            courseid = idd;
        }
        if (status2 == 2) {
            videoid = idd;
        }
        moneyService.addcv(courseid, videoid, user.getId());

        return "redirect:tobuy";
    }


    /**
     * out_trade_no 商户订单号，必填
     * subject订单名称，必填
     * total_amount付款金额，必填
     * body商品描述
     * id 课程视屏id
     *
     * @throws
     */
    @RequestMapping("alipay")
    @ResponseBody
    public String alipay(String subject, String total_amount, String body, Integer id, Integer status, HttpServletRequest request) throws AlipayApiException {


        AlipayBean alipayBean = new AlipayBean();

        alipayBean.setBody(body);

        SimpleDateFormat idd = new SimpleDateFormat("yyyyMMddHHmmss");

        String out_trade_no = idd.format(new Date());

        alipayBean.setOut_trade_no(out_trade_no);

        alipayBean.setTotal_amount(new StringBuffer().append(total_amount));

        alipayBean.setSubject(subject);

        return AlipayUtil.connect(alipayBean);

    }

    @Autowired
    private Constants constants;

    @RequestMapping("getCode")
    @ResponseBody
    public String getCode() throws Exception {
        //拼接url
        StringBuilder url = new StringBuilder();
        url.append("https://graph.qq.com/oauth2.0/authorize?");
        url.append("response_type=code");
        url.append("&client_id=" + constants.getQqAppId());
        //回调地址 ,回调地址要进行Encode转码
        String redirect_uri = constants.getQqRedirectUrl();
        //转码
        url.append("&redirect_uri=" + URLEncodeUtil.getURLEncoderString(redirect_uri));
        url.append("&state=ok");
        String result = HttpClientUtils.get(url.toString(), "UTF-8");
        System.out.println(url.toString());
        return url.toString();
    }

    /**
     * 获取token,该步骤返回的token期限为一个月
     *
     * @param code
     * @return
     * @throws Exception
     */
    @RequestMapping("callback")
    public String getAccessToken(String code) throws Exception {
        if (code != null) {
            System.out.println(code);
        }
        StringBuilder url = new StringBuilder();
        url.append("https://graph.qq.com/oauth2.0/token?");
        url.append("grant_type=authorization_code");
        url.append("&client_id=" + constants.getQqAppId());
        url.append("&client_secret=" + constants.getQqAppSecret());
        url.append("&code=" + code);
        //回调地址
        String redirect_uri = constants.getQqRedirectUrl();
        //转码
        url.append("&redirect_uri=" + URLEncodeUtil.getURLEncoderString(redirect_uri));
        String result = HttpClientUtils.get(url.toString(), "UTF-8");
        System.out.println(result);
        System.out.println("url:" + url.toString());
        //把token保存
        String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(result, "&");
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        String accessToken = StringUtils.substringAfterLast(items[0], "=");
        Long expiresIn = new Long(StringUtils.substringAfterLast(items[1], "="));

        String refreshToken = StringUtils.substringAfterLast(items[2], "=");
        if (qqProperties.get("accessToken") != null) {
            qqProperties.remove("accessToken");
        }
        if (qqProperties.get("expiresIn") != null) {
            qqProperties.remove("expiresIn");
        }
        if (qqProperties.get("refreshToken") != null) {
            qqProperties.remove("refreshToken");
        }
        qqProperties.put("accessToken", accessToken);
        qqProperties.put("expiresIn", expiresIn);
        qqProperties.put("refreshToken", refreshToken);

        return "redirect:getOpenId";
    }

    /**
     * 获取用户openId
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("getOpenId")
    public String getOpenId() throws Exception {
        StringBuilder url = new StringBuilder("https://graph.qq.com/oauth2.0/me?");
        //获取保存的用户的token
        String accessToken = (String) qqProperties.get("accessToken");
        if (!StringUtils.isNotEmpty(accessToken)) {
            return "未授权";
        }
        url.append("access_token=" + accessToken);
        String result = HttpClientUtils.get(url.toString(), "UTF-8");
        String openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
        System.out.println(openId);
        //把openId存到map中
        if (qqProperties.get("openId") != null) {
            qqProperties.remove("openId");
        }
        qqProperties.put("openId", openId);
        return "redirect:getUserInfo";
    }

    /**
     * 根据openId获取用户信息
     */
    @RequestMapping("getUserInfo")
    public String getUserInfo(HttpServletRequest request) throws Exception {
        StringBuilder url = new StringBuilder("https://graph.qq.com/user/get_user_info?");
        //取token
        String accessToken = (String) qqProperties.get("accessToken");
        String openId = (String) qqProperties.get("openId");
        if (!StringUtils.isNotEmpty(accessToken) || !StringUtils.isNotEmpty(openId)) {
            return null;
        }
        url.append("access_token=" + accessToken);
        url.append("&oauth_consumer_key=" + constants.getQqAppId());
        url.append("&openid=" + openId);
        String result = HttpClientUtils.get(url.toString(), "UTF-8");
        Object json = JSON.parseObject(result, QQUserInfo.class);
        QQUserInfo QQUserInfo = (QQUserInfo) json;
        UserBean user = new UserBean();
        user.setName(QQUserInfo.getNickname());
        user.setStatus("1");
        request.getSession().setAttribute("user", user);
        return "tiao";
    }

}
