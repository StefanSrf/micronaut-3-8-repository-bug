package com.repositorybug

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import java.time.LocalDateTime
import java.util.*

@JdbcRepository(dialect = Dialect.H2)
interface DemoCrudRepository : CrudRepository<DemoEntity, Int> {
    fun findMaxPublishedDateByName(name: String): Optional<LocalDateTime>
}