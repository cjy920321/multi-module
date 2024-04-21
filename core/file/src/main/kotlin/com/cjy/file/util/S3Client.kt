package com.cjy.file.util

import com.cjy.file.properties.S3Properties
import com.amazonaws.ClientConfiguration
import com.amazonaws.Protocol
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.internal.Mimetypes
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.util.StringUtils
import java.io.InputStream
import java.util.*

class S3Client(private val s3Properties: S3Properties) {

    private val s3Client: AmazonS3 by lazy { init() }

    companion object {

        @JvmStatic
        fun getFileExt(fileName: String?): String {
            if (fileName == null) {
                return ""
            }
            var ext = ""
            val lastPeriodIndex: Int = fileName.lastIndexOf(".")
            if (lastPeriodIndex > 0 && lastPeriodIndex + 1 < fileName.length) {
                ext = StringUtils.lowerCase(fileName.substring(lastPeriodIndex + 1))
            }
            return ext
        }

        @JvmStatic
        fun generateTargetFileName(fileName: String?): String {
            val ext = getFileExt(fileName)
            val key = UUID.randomUUID().toString().uppercase(Locale.getDefault()).replace("-", "")
            return if (ext.isNotEmpty()) "$key.$ext" else key
        }
    }

    private fun init(): AmazonS3 {
        val credentials = BasicAWSCredentials(s3Properties.accessKey, s3Properties.secretKey)
        val clientConfig = ClientConfiguration()

        //访问协议
        clientConfig.protocol = Protocol.HTTP
        return AmazonS3ClientBuilder.standard()
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .withClientConfiguration(clientConfig)
            .withEndpointConfiguration(
                AwsClientBuilder.EndpointConfiguration(s3Properties.endpoint, "")
            )
            .build()
    }

    fun upload(prefix: String = "", inputStream: InputStream, originFileName: String? = null,
               useOriginFileName: Boolean = false, length: Long = inputStream.available().toLong()): String {
        val ext = getFileExt(originFileName)
        val targetFileName = if (!useOriginFileName) generateTargetFileName(prefix, ext) else originFileName
        s3Client.putObject(s3Properties.bucketName, targetFileName, inputStream,
            generateObjectMeta(originFileName, length, ext))
        return "${s3Properties.endpoint}/${s3Properties.bucketName}/$targetFileName"
    }

    fun download(fileName: String): S3Object {
        return s3Client.getObject(s3Properties.bucketName, fileName)
    }

    fun delete(fileName: String) {
        s3Client.deleteObject(s3Properties.bucketName, fileName)
    }

    fun hasObject(fileName: String):Boolean {
        return s3Client.doesObjectExist(s3Properties.bucketName, fileName)
    }

    private fun generateObjectMeta(fileName: String?, length: Long, ext: String): ObjectMetadata {
        val metadata = ObjectMetadata()
        if ("mp3" == ext) {
            metadata.contentType = "audio/mpeg"
        } else {
            metadata.contentType = Mimetypes.getInstance().getMimetype(fileName)
        }
        metadata.contentLength = length
        return metadata
    }

    private fun generateTargetFileName(prefix: String, ext: String): String = generateTargetFileName(prefix, ext,
        UUID.randomUUID().toString().uppercase(Locale.getDefault()).replace("-", ""))


    private fun generateTargetFileName(prefix: String?, ext: String, key: String) =
        if (ext.isNotEmpty()) "${prefix ?: ""}$key.$ext" else "${prefix ?: ""}$key"
}