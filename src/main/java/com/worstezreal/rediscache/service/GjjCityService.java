package com.worstezreal.rediscache.service;

import com.alibaba.fastjson.JSONObject;
import com.worstezreal.rediscache.dao.GjjCityDao;
import com.worstezreal.rediscache.dto.CityConfigDTO;
import com.worstezreal.rediscache.entity.GjjCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc
 *
 * @author zengxzh@yonyou.com
 * @version V1.0.0
 * @date 2018/8/16
 */
@Service
public class GjjCityService {

    @Autowired
    private GjjCityDao cityDao;

    @Autowired
    private RestTemplate restTemplate;

    @Cacheable(value = "city_config", keyGenerator = "methodKeyGenerator")
    public List<CityConfigDTO> getCityConfig() {
        List<CityConfigDTO> result = new ArrayList<>();
        List<GjjCity> cityList = cityDao.getCityConfig(null);
        String json = restTemplate.getForObject("https://t.51gjj.com/gjjapi/getCity", String.class);
        List<JSONObject> jsonObjects = JSONObject.parseObject(json, JSONObject.class).getJSONArray("data").toJavaList(JSONObject.class);
        for (GjjCity gjjCity : cityList) {
            boolean flag = false;
            for (JSONObject jsonObject : jsonObjects) {
                List<CityConfigDTO> cityConfigList = jsonObject.getJSONArray("citys").toJavaList(CityConfigDTO.class);
                for (CityConfigDTO cityConfigDTO : cityConfigList) {
                    if (gjjCity.getFiveoneId().equals(cityConfigDTO.getId().toString())) {
                        result.add(cityConfigDTO);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        return result;
    }

    @Cacheable(value = "fiveoneconfig",keyGenerator = "methodKeyGenerator")
    public String fiveoneConfig() {
        return restTemplate.getForObject("https://t.51gjj.com/gjjapi/getCity", String.class);
    }

}
