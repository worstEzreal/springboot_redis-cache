package com.worstezreal.rediscache.controller;

import com.worstezreal.rediscache.Result;
import com.worstezreal.rediscache.enums.CodeEnum;
import com.worstezreal.rediscache.service.GjjCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc
 *
 * @author zengxzh@yonyou.com
 * @version V1.0.0
 * @date 2018/8/16
 */
@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private GjjCityService service;

    @RequestMapping("/config")
    public Result config() {
        return new Result(CodeEnum.SUCCESS, service.getCityConfig());
    }

    @RequestMapping("/fiveone")
    public Result fiveone() {
        return new Result(CodeEnum.SUCCESS, service.fiveoneConfig());
    }

}
