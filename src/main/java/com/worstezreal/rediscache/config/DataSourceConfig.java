package com.worstezreal.rediscache.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Desc
 *
 * @author zengxzh@yonyou.com
 * @version V1.0.0
 * @date 2018/8/16
 */
@Configuration
@MapperScan(basePackages = "com.worstezreal.rediscache.**.dao")
public class DataSourceConfig {
}
