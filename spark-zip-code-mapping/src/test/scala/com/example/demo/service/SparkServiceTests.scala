package com.example.demo.service

import org.apache.spark.sql.{SparkSession}
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
class SparkServiceTests {

    var sparkSession : SparkSession = null

    @Autowired(required = false)
    def setMyServiceB(sparkSession : SparkSession): Unit = {
      this.sparkSession = sparkSession
    }

    @Test
    def TEST1() : Unit = {
        val df = sparkSession.read.json("../spark/resources/people.json")

        df.show();

        println("TEST")
    }

    @Test
    def TEST2() : Unit = {
        val df = sparkSession.read.text("../spark/test.txt")

        df.show();

        println("TEST")
    }

}
