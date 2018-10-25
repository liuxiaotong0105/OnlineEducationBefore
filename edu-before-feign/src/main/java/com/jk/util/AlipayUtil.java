/**
 * <pre>项目名称:before-consumer
 * 文件名称:AlipayUtil.java
 * 包名:com.jk.config
 * 创建日期:2018年9月18日下午3:29:03
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre>
 */
package com.jk.util;


import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jk.config.PropertiesConfig;
import com.jk.modelapi.AlipayBean;

/**
 * <pre>项目名称：before-consumer
 * 类名称：AlipayUtil
 * 类描述：
 * 创建人：张培科
 * 创建时间：2018年9月18日 下午3:29:03
 * 修改人：
 * 修改时间：2018年9月18日 下午3:29:03
 * 修改备注：
 * @version </pre>
 */
public class AlipayUtil {
    public static String connect(AlipayBean alipayBean) throws AlipayApiException {
        //1、获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(
                PropertiesConfig.getKey("gatewayUrl"),//支付宝网关
                PropertiesConfig.getKey("app_id"),//appid
                PropertiesConfig.getKey("merchant_private_key"),//商户私钥
                "json",
                PropertiesConfig.getKey("charset"),//字符编码格式
                PropertiesConfig.getKey("alipay_public_key"),//支付宝公钥
                PropertiesConfig.getKey("sign_type")//签名方式

        );


        //2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(PropertiesConfig.getKey("return_url"));
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(PropertiesConfig.getKey("notify_url"));
        //封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));

        //3、请求支付宝进行付款，并获取支付结果
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        //返回付款信息
        return  result;
    }
}

