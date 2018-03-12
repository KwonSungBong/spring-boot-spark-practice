package template.spark

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
class TestApplication {

  @Test
  def test(): Unit = {
    val appName = "test"
    val sparkHome = "/home/whilemouse/git/spark/spark-2.2.0-bin-hadoop2.7"
    val masterUri = "local"

    val conf: SparkConf = new SparkConf().setAppName(appName).setSparkHome(sparkHome).setMaster(masterUri)
    val sc: SparkContext = new SparkContext(conf)
    val sqlContext: SQLContext = new SQLContext(sc)
    import sqlContext.implicits._

//    case class MyCaseClass(key: String, group: String, value: Int, someints: Seq[Int], somemap: Map[String, Int])
//    val dataframe = sc.parallelize(Array(MyCaseClass("a", "vowels", 1, Array(1), Map("a" -> 1)),
//      MyCaseClass("b", "consonants", 2, Array(2, 2), Map("b" -> 2)),
//      MyCaseClass("c", "consonants", 3, Array(3, 3, 3), Map("c" -> 3)),
//      MyCaseClass("d", "consonants", 4, Array(4, 4, 4, 4), Map("d" -> 4)),
//      MyCaseClass("e", "vowels", 5, Array(5, 5, 5, 5, 5), Map("e" -> 5)))
//    ).toDF()
//    dataframe.write.mode("overwrite").parquet("/home/whilemouse/git/spring-boot-spark-practice/simple-service/temp")

//    val data = sqlContext.read.parquet("/home/whilemouse/git/spring-boot-spark-practice/simple-service/temp")

//    case class Foobar(foo: String, bar: Integer)
//
//    val foobarRdd = sc.parallelize(("foo", 1) :: ("bar", 2) :: ("baz", -1) :: Nil).
//      map { case (foo, bar) => Foobar(foo, bar) }
//
//    val foobarDf = foobarRdd.toDF

    val data = Array(1, 2, 3, 4, 5)
    val distData = sc.parallelize(data)

//    dataframe.write.mode("overwrite").parquet("/home/whilemouse/git/spring-boot-spark-practice/simple-service/temp")
  }

}
