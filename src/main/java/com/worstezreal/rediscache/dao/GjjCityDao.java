package com.worstezreal.rediscache.dao;

import com.worstezreal.rediscache.entity.GjjCity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GjjCityDao {
    int insert(GjjCity record);

    int insertSelective(GjjCity record);

    GjjCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GjjCity record);

    int updateByPrimaryKey(GjjCity record);

    List<GjjCity> getCityConfig(@Param("taskType") String taskType);
}