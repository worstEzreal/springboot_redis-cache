package com.worstezreal.rediscache.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.worstezreal.rediscache.entity.GjjCity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 城市配置DTO
 *
 * @author zengxzh@yonyou.com
 * @version V1.0.0
 * @date 2018/6/20
 */
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CityConfigDTO extends GjjCity {


    private String cityId;
    private Integer state;
    private boolean enabled = true;

    @JSONField(name = "loginWay", alternateNames = {"loginWays", "queryStepParam"})
    private List<QueryStepParam> loginWay;


    @Setter
    @Getter
    public static class QueryStepParam implements Serializable {
        @JSONField(alternateNames = {"loginParams", "loginParam"})
        private List<LoginParam> loginParam;
        private boolean enabled = true;
    }

    @Setter
    @Getter
    public static class LoginParam implements Serializable {
        private String note;
        private String label;
        private String name;
        private String type;
    }
}
