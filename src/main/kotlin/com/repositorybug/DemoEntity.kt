package com.repositorybug

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.time.LocalDateTime


@Introspected
@MappedEntity
data class DemoEntity(
    @field:Id
    val id: Long,
    val name: String,
    val publishedDate: LocalDateTime?,
)