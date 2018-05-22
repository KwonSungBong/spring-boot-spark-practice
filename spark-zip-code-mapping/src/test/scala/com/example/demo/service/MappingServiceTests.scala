package com.example.demo.service

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
class MappingServiceTests {

    var mappingService : MappingService = _

    @Autowired
    def setMappingService(mappingService : MappingService) = this.mappingService = mappingService

    @Test
    def TEST() = {
        mappingService.mapping()

        println("test")
    }

    @Test
    def TEST1(): Unit = {
//        mappingService.readNew
//        mappingService.writeParquetNew
//        mappingService.readParquetNew
    }

    @Test
    def TEST2(): Unit ={
//        mappingService.readOld
//        mappingService.writeParquetOld
//        mappingService.readParquetOld()
    }

}
