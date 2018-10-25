package com.jk.controller;


<<<<<<< HEAD
import com.jk.modelapi.Movie;
=======
>>>>>>> e1715199ebf80a549510bbccc29ae0f790a98bbe
import com.jk.modelapi.UserBean;
import com.jk.serviceapi.LoginServiceApi;

import com.jk.util.*;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
>>>>>>> e1715199ebf80a549510bbccc29ae0f790a98bbe
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
import java.io.IOException;
import java.util.*;
=======
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
>>>>>>> e1715199ebf80a549510bbccc29ae0f790a98bbe
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 赵黎明
 * @Date: 2018/10/21 11:08
 * 描述: 用一段话来简述
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginServiceApi loginServiceApi;

    @Resource
    private RedisTemplate<String,String> redisTemplate;


<<<<<<< HEAD


=======
>>>>>>> e1715199ebf80a549510bbccc29ae0f790a98bbe
    @RequestMapping("toLogin")
    public String  toLogin(){

        return "login";
    }

    /**
     * 用户登录验证
     * @return</pre>
     */
    @RequestMapping("loginUser")
    @ResponseBody
    public Map<String, Object> loginUser(String imgVerify, UserBean userBean, HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        HttpSession session = request.getSession();
        String imgcode = session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY).toString();
        if (!imgVerify.equals(imgcode)) {
            hashMap.put("code", 1);
            hashMap.put("msg", "验证码错误");
            return hashMap;
        }
        UserBean userInfo = loginServiceApi.getUserByLoginName(userBean);
        if (userInfo == null) {
            hashMap.put("code", 2);
            hashMap.put("msg", "账号或密码错误");
            return hashMap;
        }
        if (!userInfo.getPassword().equals(userBean.getPassword())) {
            hashMap.put("code", 2);
            hashMap.put("msg", "账号或密码错误");
            return hashMap;
        }
        hashMap.put("code", 0);
<<<<<<< HEAD
        userInfo.setStatus("1");
        session.setAttribute("user", userInfo);
=======
        session.setAttribute(session.getId(), userInfo);
>>>>>>> e1715199ebf80a549510bbccc29ae0f790a98bbe
        return hashMap;
    }


    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request,response);//输出验证码图片方法
        } catch (Exception e) {

        }
    }

    //切换快速登录
    @RequestMapping("toQucikLogin")
    public String toQucikLogin(){

        return "quickLogin";
    }

    /**
     * 跳转主页面
     * @return
     */
    @RequestMapping("toMain")
<<<<<<< HEAD
    public String toMain(HttpServletRequest request) {


        String status = "";
        UserBean attribute =  (UserBean) request.getSession().getAttribute("user");
        if (attribute != null) {
            status = attribute.getStatus();
            request.setAttribute("user",attribute);
            request.setAttribute("status",status);
        }else{
            request.setAttribute("status",status);
        }
        return "index";
=======
    public String toMain() {
        return "view/index";
>>>>>>> e1715199ebf80a549510bbccc29ae0f790a98bbe
    }

    /**
     * 获取快速登录的验证码
     * @return
     */
    @RequestMapping("sendSmsName")
    @ResponseBody
    public Boolean sendSmsName(String phone,HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            UserBean userBean=loginServiceApi.getUserphoneName(phone);
            if(phone==null) {
                return false;
            }else{
                if(userBean.getPhone().equals(phone)) {
                    //缓存验证码key 为了保证唯一 特定字符加上手机号
                    String cacheCodekey = Constant.LOGIN_CODE + phone;
                    //缓存1分钟锁key
                    String cacheFlagkey = Constant.LOGIN_CODE_FLAG + phone;
                    //判断证号距离上一次获取是否距离1分钟
                    String lock = redisTemplate.opsForValue().get(cacheFlagkey);
                    if(StringUtils.isEmpty(lock)) {
                        int random = (int) ((Math.random()*9+1)*100000);
                        HashMap<String,Object> params=new HashMap<>();
                        params.put("accountSid", Constant.ACCOUNTSID);
                        params.put("templateid", Constant.TEMPLATEID);
                        params.put("param",""+random+"");
                        params.put("to", phone);
                        String timestamp = TimeUtil.format(new Date());
                        params.put("timestamp", timestamp);
                        String sign= Md5Util.getMd532(Constant.ACCOUNTSID+Constant.AUTH_TOKEN+timestamp);
                        params.put("sig", sign);
                        HttpClientUtil.post(Constant.SMS_URL, params);
                        redisTemplate.opsForValue().set(cacheCodekey, ""+random+"", Constant.LOGIN_CODE_TIME_OUT, TimeUnit.MINUTES);
                        redisTemplate.opsForValue().set(cacheFlagkey, "lock",1,TimeUnit.MINUTES);
                        session.setAttribute(session.getId(),phone);
                    }else {
                        System.out.println("1分钟内不能重复获取验证码");
                        return false;
                    }
                }else {
                    System.out.println("手机号不能为空");
                    return false;
                }
            }
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println("异常:"+e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 快速登录的方法
     * @return
     */
    @RequestMapping("sendSmsNameCode")
    @ResponseBody
    public Map<String, Object> sendSmsNameCode(String smsCode,String phone,HttpServletRequest request){
        HashMap<String,Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        UserBean userBean=loginServiceApi.getUserphoneName(phone);
        String cacheCodekey = Constant.LOGIN_CODE + phone;
        String smsCodeName = redisTemplate.opsForValue().get(cacheCodekey);
        if(!smsCode.equals(smsCodeName)){
            result.put("code", 2);
            result.put("msg","验证码错误");
            return result;
        }
<<<<<<< HEAD
        userBean.setStatus("1");
        session.setAttribute("user",userBean);
        result.put("code", 0);
        return result;
    }
    /**
     * @return注销
     */

    @RequestMapping("removeUser")
    public String removeUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:toMain";
    }



=======
        session.setAttribute(session.getId(),phone);
        result.put("code", 0);
        return result;
    }
>>>>>>> e1715199ebf80a549510bbccc29ae0f790a98bbe
    @RequestMapping("toRegistered")
    public String toRegistered(){

        return "registered";
    }

    /**
     * 注册
     * @return</pre>
     */
    @RequestMapping("addUser")
    @ResponseBody
    public Map<String, Object> addUser(UserBean userBean, HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        HttpSession session = request.getSession();
        String imgVerify = userBean.getImgVerify();
        String imgcode = session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY).toString();
        String phone = userBean.getPhone();
        UserBean userBean2=loginServiceApi.getUserphoneName(phone);
        if (!imgVerify.equals(imgcode)) {
            hashMap.put("code", 1);
            hashMap.put("msg", "验证码错误");
            return hashMap;
        }
        if (userBean2!=null) {
            hashMap.put("code", 3);
            hashMap.put("msg", "手机已经注册");
            return hashMap;
        }


        try {
            loginServiceApi.addUser(userBean);
        } catch (Exception e) {
            hashMap.put("code", 2);
            hashMap.put("msg", "注册失败");
            return hashMap;
        }
        hashMap.put("code", 0);
        hashMap.put("msg", "注册成功");
        return hashMap;
    }



}
