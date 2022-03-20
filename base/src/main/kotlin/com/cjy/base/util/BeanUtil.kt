package com.cjy.base.util

import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component
import kotlin.properties.Delegates

@Component
class BeanUtil : ApplicationContextAware {
    @Throws(BeansException::class)
    override fun setApplicationContext(context: ApplicationContext) {
        // store ApplicationContext reference to access required beans later on
        BeanUtil.context = context
    }

    companion object {
        private var context: ApplicationContext by Delegates.notNull()

        fun <T : Any>getBean(beanClass: Class<T>): T {
            return context.getBean(beanClass)
        }
    }
}