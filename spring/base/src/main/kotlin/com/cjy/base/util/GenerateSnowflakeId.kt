package com.cjy.base.util

import java.util.Properties
import org.hibernate.HibernateException
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import org.springframework.data.mapping.MappingException
import java.io.Serializable
import org.hibernate.service.ServiceRegistry
import org.hibernate.type.Type

class GenerateSnowflakeId : IdentifierGenerator {
    @Throws(MappingException::class)
    override fun configure(type: Type?, params: Properties?, serviceRegistry: ServiceRegistry?) {
    }

    @Throws(HibernateException::class)
    override fun generate(session: SharedSessionContractImplementor, `object`: Any): Serializable {
        return BeanUtil.getBean(Snowflake::class.java).nextId()
    }
}