package com.jk.service;

import com.jk.serviceapi.MoneyServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: ${赵成林}
 * @Date: 2018/10/22 16:24o
 * @Description:
 */
@FeignClient(value = "service-edubefores")
public interface MoneyService extends MoneyServiceApi{
}
