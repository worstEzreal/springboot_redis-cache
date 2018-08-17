package com.worstezreal.rediscache.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * 公积金中心编号
 * gjj_city
 */
@Data
public class GjjCity implements Serializable {
    /**
     * 公积金中心编号
     */
    private Integer id;

    /**
     * 公积金中心名称
     */
    @JSONField(alternateNames = "cityName")
    private String centerName;

    /**
     * 城市
     */
    private String city;

    /**
     * 考拉id
     */
    @JsonIgnore
    private String koalaId;

    /**
     * 51公积金id
     */
    @JsonIgnore
    private String fiveoneId;

    /**
     * 是否可用
     */
    private Short enable;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 任务类型
     */
    private String taskType;

    private static final long serialVersionUID = 1L;

    public boolean isEnabled() {
        return enable.equals((short) 1);
    }

}