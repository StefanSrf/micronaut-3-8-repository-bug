package com.repositorybug

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.reactive.ReactorCrudRepository
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.util.*

@JdbcRepository(dialect = Dialect.H2)
interface DemoReactorRepository : ReactorCrudRepository<DemoEntity, Long> {

    fun findByName(name: String): Mono<DemoEntity>
    fun findMaxPublishedDate(): Mono<LocalDateTime>

    // the following line fails to compile/generate with kaptKotlin with micronaut 3.8.1 (until 3.8.0 it worked fine):
    // error: Unable to implement Repository method: DemoReactorRepository.findMaxPublishedDateByName(String name). Cannot project on non-existent property publishedDateByName
    //    public abstract reactor.core.publisher.Mono<java.time.LocalDateTime> findMaxPublishedDateByName(@org.jetbrains.annotations.NotNull()
    fun findMaxPublishedDateByName(name: String): Mono<LocalDateTime>
}