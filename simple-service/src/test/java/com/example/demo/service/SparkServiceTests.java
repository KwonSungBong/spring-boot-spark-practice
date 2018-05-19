package com.example.demo.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ksb on 2018. 2. 5..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SparkServiceTests {

    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private SparkSession sparkSession;

    @Test
    public void TEST1() {
        JavaRDD<String> inFile = sc.textFile("../spark/csv/simple.csv");

        List<String> stringList = inFile.collect();

        System.out.println();
    }

    @Test
    public void TEST2() {
        Dataset<Row> df = sparkSession.read().json("../spark/resources/people.json");

        df.show();

//        df.printSchema();sunt().show();

        df.createOrReplaceTempView("people");
        Dataset<Row> sqlDF = sparkSession.sql("SELECT * FROM people");
        sqlDF.show();

        System.out.println();

        sparkSession.stop();
    }

}
