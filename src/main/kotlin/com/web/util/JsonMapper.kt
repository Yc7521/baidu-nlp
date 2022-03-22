package com.web.util

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.io.InputStream
import java.io.OutputStream

object JsonMapper {
    val mapper: ObjectMapper = ObjectMapper()
    val log: Logger = LoggerFactory.getLogger(JsonMapper::class.java)

    fun configure(config: ObjectMapper.() -> Unit) {
        mapper.config()
    }
}

fun <T> T.toJson(): String {
    return try {
        JsonMapper.mapper.writeValueAsString(this)
    } catch (e: JsonProcessingException) {
        JsonMapper.log.error("Failed to serialize object to JSON", e)
        throw e
    }
}

fun <T> T.toJson(file: File): T {
    return try {
        JsonMapper.mapper.writeValue(file, this)
        this
    } catch (e: JsonProcessingException) {
        JsonMapper.log.error("Failed to serialize object to JSON", e)
        throw e
    }
}

fun <T> T.toJson(outputStream: OutputStream): T {
    return try {
        JsonMapper.mapper.writeValue(outputStream, this)
        this
    } catch (e: JsonProcessingException) {
        JsonMapper.log.error("Failed to serialize object to JSON", e)
        throw e
    }
}

inline fun <reified T> String.fromJson(): T {
    return try {
        JsonMapper.mapper.readValue(this, T::class.java)
    } catch (e: JsonProcessingException) {
        JsonMapper.log.error("Failed to deserialize JSON to object", e)
        throw e
    }
}

inline fun <reified T> File.fromJson(): T {
    return try {
        JsonMapper.mapper.readValue(this, T::class.java)
    } catch (e: JsonProcessingException) {
        JsonMapper.log.error("Failed to deserialize JSON to object", e)
        throw e
    }
}

inline fun <reified T> InputStream.fromJson(): T {
    return try {
        JsonMapper.mapper.readValue(this, T::class.java)
    } catch (e: JsonProcessingException) {
        JsonMapper.log.error("Failed to deserialize JSON to object", e)
        throw e
    }
}
