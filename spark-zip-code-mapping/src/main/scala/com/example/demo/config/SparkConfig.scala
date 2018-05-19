package com.example.demo.config

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class SparkConfig {

  private def appName = "test"
  private def sparkHome = "../spark/spark-2.2.0-bin-hadoop2.7"
  private def masterUri = "local"

  @Bean
  def sparkConf() : SparkConf = {
    val sparkConf = new SparkConf().setAppName(appName).
      setSparkHome(sparkHome).setMaster(masterUri).
      set("spark.driver.host", "localhost")
    sparkConf
  }

  @Bean
  def sparkSession() : SparkSession = {
    val sparkSession = SparkSession.builder.
      config(sparkConf).getOrCreate();
    sparkSession
  }

}
