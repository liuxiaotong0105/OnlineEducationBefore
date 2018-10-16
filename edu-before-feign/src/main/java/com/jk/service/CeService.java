package com.jk.service;

import com.jk.serviceapi.CeServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <pre>项目名称：springCloud
 * 类名称：UserServiceImpl
 * 类描述：
 * 创建人：刘晓彤
 * 创建时间：2018/10/12  19:05
 * 手机号：18511777907&16619767907
 * 备注：生命不息，车轮不止
 */

@FeignClient(value = "service-edubefores")
public interface CeService extends CeServiceApi {

}
