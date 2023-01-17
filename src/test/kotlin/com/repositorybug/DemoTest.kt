package com.repositorybug

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


@MicronautTest(rollback = false)
class DemoTest {

    @Inject
    lateinit var demoCrudRepository: DemoCrudRepository

    @Inject
    lateinit var demoReactorRepository: DemoReactorRepository

    @Test
    fun `should find with crud repository`() {
        demoCrudRepository.deleteAll()
        val parentId = 1L
        val publishedDate = LocalDateTime.of(2023, 1, 17, 8, 25)
        val parentToSave = DemoEntity(parentId, "parent", publishedDate)
        demoCrudRepository.save(parentToSave)

        val result = demoCrudRepository.findMaxPublishedDateByName("parent").get()

        assertEquals(publishedDate, result)
    }

    @Test
    fun `should find with reactor repository`() {
        demoCrudRepository.deleteAll()
        val parentId = 1L
        val publishedDate = LocalDateTime.of(2023, 1, 17, 8, 25)
        val parentToSave = DemoEntity(parentId, "parent", publishedDate)
        demoCrudRepository.save(parentToSave)

        val result = demoReactorRepository.findMaxPublishedDateByName("parent").block()

        assertEquals(publishedDate, result)
    }
}
