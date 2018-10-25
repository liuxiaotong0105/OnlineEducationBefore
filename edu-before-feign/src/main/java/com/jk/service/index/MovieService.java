package com.jk.service.index;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-edubefores")
public interface MovieService {


}
