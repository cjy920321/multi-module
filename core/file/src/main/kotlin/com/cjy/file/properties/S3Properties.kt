package com.cjy.file.properties

data class S3Properties(
    val endpoint: String,
    val accessKey: String,
    val secretKey: String,
    val bucketName: String)