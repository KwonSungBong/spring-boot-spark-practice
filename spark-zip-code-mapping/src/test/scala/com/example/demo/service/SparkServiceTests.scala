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

    var sparkSession : SparkSession = _

    @Autowired
    def setSparkSession(sparkSession : SparkSession) = this.sparkSession = sparkSession

    @Test
    def TEST0() = {
        val test1 = 1 to 10 mkString("[", ",", "]")
        val test2 = 1 until 10 mkString("[", ",", "]")
        val test3 = 1 to 10 by 3 mkString("[", ",", "]")
        val test4 = 1 until 10 by 3 mkString("[", ",", "]")

        println("test1 : %s", test1)
        println("test2 : %s", test2)
        println("test3 : %s", test3)
        println("test4 : %s", test4)
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
