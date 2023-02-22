package com.cjy.base.config

import com.cjy.base.properties.SnowflakeProperties
import com.cjy.common.util.Snowflake
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SnowflakeConfig {

    /**
     * 初始化SnowflakeIdWorker Bean
     *
     * @return SnowflakeIdWorker
     */
    @Bean
    fun snowflake(snowflakeProperties: SnowflakeProperties): Snowflake {
        return Snowflake(snowflakeProperties.workerId, snowflakeProperties.datacenterId)
    }
}