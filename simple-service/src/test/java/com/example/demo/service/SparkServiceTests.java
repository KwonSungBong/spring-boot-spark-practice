package com.example.demo.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
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

    @Test
    public void test() {
        JavaRDD<String> inFile = sc.textFile("../spark/csv/simple.csv");

        List<String> stringList = inFile.collect();

        System.out.println();

    }

}
