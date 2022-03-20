package com.cjy.base.util

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

class ParamUtil {

    companion object {
        private const val DEFAULT_PAGE_NUMBER = 0
        private const val DEFAULT_PAGE_SIZE = 20

        @JvmStatic
        fun buildPage(pageNumber: Int?, pageSize: Int?): Pageable {
            return PageRequest.of(pageNumber ?: DEFAULT_PAGE_NUMBER, pageSize ?: DEFAULT_PAGE_SIZE)
        }
    }
}