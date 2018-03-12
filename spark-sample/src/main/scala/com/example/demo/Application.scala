package com.example.demo

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object Application {

  def main(args: Array[String]): Unit = {
    val appName = "test"
    val sparkHome = "/home/whilemouse/git/spark/spark-2.2.0-bin-hadoop2.7"
    val masterUri = "local"

    val conf: SparkConf = new SparkConf().setAppName(appName).setSparkHome(sparkHome).setMaster(masterUri)
    val sc: SparkContext = new SparkContext(conf)
    val sqlContext: SQLContext = new SQLContext(sc)
    import sqlContext.implicits._

    println("testtesttesttest")
  }
}
