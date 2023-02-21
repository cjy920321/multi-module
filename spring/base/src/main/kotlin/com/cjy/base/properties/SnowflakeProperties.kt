package com.cjy.base.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "snowflake")
data class SnowflakeProperties(
    /**
     * 工作节点ID
     */
    val workerId: Long = 0,

    /**
     * 数据中心ID
     */
    val datacenterId: Long = 0
)