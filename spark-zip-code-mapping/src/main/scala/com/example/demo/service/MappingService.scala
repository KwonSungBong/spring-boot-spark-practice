package com.example.demo.service

import org.apache.spark.sql.SparkSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MappingService @Autowired()(sparkSession : SparkSession) {

  val newDirectoryPath = "data/new/20180509/"
  val oldDirectoryPath = "data/old/20150827/"
  val txtExt = ".txt"
  val parquetExt = ".parquet"
  val newName = "new_20180509_"
  val oldName = "old_20150827_"

  def mapping(): Unit = {
    val newList = readNew()
    val oldList = readOld()

    val newZipCodeMappingMap = newList.groupBy(_._1).map { case (k,v) => (k,v.map(_._2))}
    val oldZipCodeMappingMap = oldList.groupBy(_._1).map { case (k,v) => (k,v.map(_._2))}

    val zipCodeMappingList = oldZipCodeMappingMap.map(oldZipCodeMapping => {
      val newZipCodeMapping = newZipCodeMappingMap.contains(oldZipCodeMapping._1)
      if(newZipCodeMapping) (oldZipCodeMapping._2, newZipCodeMappingMap(oldZipCodeMapping._1))
      else (oldZipCodeMapping._2, List.empty)
    })

    println("mapping")
  }

  def readNew() = {
    val list = 0 to 14 map(index => {
      sparkSession.sparkContext.textFile(newDirectoryPath+index+txtExt).collect()
    })

    val result = list.flatMap(item => item.drop(1).map(line => {
      val lineSplit = line.split("\\|")
      if(!lineSplit(5).isEmpty) {
        if(!lineSplit(17).isEmpty) {
          val mappingKey = lineSplit(1)+" "+lineSplit(3)+" "+lineSplit(5)+" "+lineSplit(17)+" "+lineSplit(8)
          (mappingKey, lineSplit(0), lineSplit(1), lineSplit(3), lineSplit(5), lineSplit(17), lineSplit(8))
        } else {
          val mappingKey = lineSplit(1)+" "+lineSplit(3)+" "+lineSplit(5)+" "+lineSplit(18)+" "+lineSplit(8)
          (mappingKey, lineSplit(0), lineSplit(1), lineSplit(3), lineSplit(5), lineSplit(18), lineSplit(8))
        }
      } else {
        if(!lineSplit(17).isEmpty) {
          val mappingKey = lineSplit(1)+" "+lineSplit(3)+" "+lineSplit(5)+" "+lineSplit(17)+" "+lineSplit(8)
          (mappingKey, lineSplit(0), lineSplit(1), lineSplit(3), lineSplit(17), null, lineSplit(8))
        } else {
          val mappingKey = lineSplit(1)+" "+lineSplit(3)+" "+lineSplit(5)+" "+lineSplit(18)+" "+lineSplit(8)
          (mappingKey, lineSplit(0), lineSplit(1), lineSplit(3), lineSplit(18), null, lineSplit(8))
        }
      }
    }).distinct)

    result
  }

  def readOld() = {
    val list = 0 to 16 map(index => {
      sparkSession.sparkContext.textFile(oldDirectoryPath+index+txtExt).collect()
    })

    val result = list.flatMap(item => item.drop(1).map(line => {
      val lineSplit = line.split("\\|")
      if(!lineSplit(5).isEmpty) {
        if(!lineSplit(17).isEmpty) {
          val mappingKey = lineSplit(2)+" "+lineSplit(4)+" "+lineSplit(6)+" "+lineSplit(18)+" "+lineSplit(9)
          (mappingKey, lineSplit(0), lineSplit(2), lineSplit(4), lineSplit(6), lineSplit(18), lineSplit(9))
        } else {
          val mappingKey = lineSplit(2)+" "+lineSplit(4)+" "+lineSplit(6)+" "+lineSplit(19)+" "+lineSplit(9)
          (mappingKey, lineSplit(0), lineSplit(2), lineSplit(4), lineSplit(6), lineSplit(19), lineSplit(9))
        }
      } else {
        if(!lineSplit(17).isEmpty) {
          val mappingKey = lineSplit(2)+" "+lineSplit(4)+" "+lineSplit(6)+" "+lineSplit(18)+" "+lineSplit(9)
          (mappingKey, lineSplit(0), lineSplit(2), lineSplit(4), lineSplit(18), null, lineSplit(9))
        } else {
          val mappingKey = lineSplit(2)+" "+lineSplit(4)+" "+lineSplit(6)+" "+lineSplit(19)+" "+lineSplit(9)
          (mappingKey, lineSplit(0), lineSplit(2), lineSplit(4), lineSplit(19), null, lineSplit(9))
        }
      }
    }).distinct)

    result
  }

  def writeParquetNew(): Unit = {
    val list = 1 to 14 foreach (index => {
      val newDF = sparkSession.read.text(newDirectoryPath+index+txtExt)
      newDF.write.parquet(newDirectoryPath+index+parquetExt)
    })
  }

  def writeParquetOld(): Unit = {
    val list = 1 to 16 map(index => {
      val oldDF = sparkSession.read.text(oldDirectoryPath+index+txtExt)
      oldDF.write.parquet(oldDirectoryPath+index+parquetExt)
    })
  }

  def readParquetNew(): Unit = {
    val list = 1 to 14 foreach (index => {
      val parquetFileDF = sparkSession.read.parquet(newDirectoryPath+index+parquetExt)
      parquetFileDF.createOrReplaceTempView(newName+index)
    })
//    val testDF = sparkSession.sql("SELECT * FROM "+newName+0+" LIMIT 2")
//    testDF.show()
//    println("mapping")
  }

  def readParquetOld(): Unit = {
    val list = 1 to 16 map(index => {
      val parquetFileDF = sparkSession.read.parquet(oldDirectoryPath+index+parquetExt)
      parquetFileDF.createOrReplaceTempView(oldName+index)
    })
//    val testDF = sparkSession.sql("SELECT * FROM "+oldName+0+" LIMIT 2")
//    testDF.show()
//    println("mapping")
  }

  //    def mapping(): Unit = {
  //    val df = sparkSession.read.text("data/new/20180509/0.txt")
  //
  //    df.show();
  //
  //    println("mapping")
  //  }

}
