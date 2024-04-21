package com.cjy.common.converter

import com.cjy.common.enums.IEnum
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.converter.ConverterFactory
import org.springframework.lang.NonNull
import org.springframework.stereotype.Component

@Component
class StringToEnumConverterFactory : ConverterFactory<String, IEnum<*>?> {
    @NonNull
    override fun <T : IEnum<*>?> getConverter(@NonNull targetType: Class<T>): Converter<String, T> {
        return StringToEnum(targetType)
    }

    private class StringToEnum<T : IEnum<*>?>(private val enumType: Class<T>) :
        Converter<String, T> {
        /**
         * StringToEnumConverterFactory默认是调用Enum.valueOf()，也就是根据Enum.name匹配
         * 我们改成根据Enum.value匹配
         *
         * @param source value
         * @return Enum
         */
        override fun convert(source: String): T? {
            if (source.isEmpty()) {
                return null
            }
            for (enumObject in enumType.enumConstants) {
                if (source == enumObject?.getValue().toString()) {
                    return enumObject
                }
            }
            return null
        }
    }
}