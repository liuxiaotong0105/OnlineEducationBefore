package com.jk.service.index;

import com.jk.modelapi.Movie;
import com.jk.serviceapi.MoviceServiceApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "service-edubefores")
public interface MovieService extends MoviceServiceApi {


}
