package com.cjy.common.util

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
        Companion.context = context
    }

    companion object {
        private var context: ApplicationContext by Delegates.notNull()

        /**
         * 通过类获取
         * @param beanClass 注入的类
         * @param <T> 返回类型
         * @return 返回这个Bean
         * @throws BeansException bean异常
        </T> */
        @JvmStatic
        fun <T : Any>getBean(beanClass: Class<T>): T {
            return context.getBean(beanClass)
        }

        @Throws(BeansException::class)
        fun <T> getBean(name: String, requiredType: Class<T>): T {
            return context.getBean(name, requiredType)
        }

        fun <T> getBeansOfType(clazz: Class<T>): Map<String, T> {
            return context.getBeansOfType(clazz)
        }
    }
}