# spring-boot-spark-practice

https://github.com/P7h/docker-spark

######################################################

docker run -it -p 4040:4040 -p 8080:8080 -p 8081:8081 -h spark --name=spark p7hb/docker-spark:2.2.0
start-master.sh
start-slave.sh spark://spark:7077

######################################################

http://spark.apache.org/docs/latest/cluster-overview.html

######################################################

cd /opt/

sudo wget http://apache.mirror.cdnetworks.com/spark/spark-2.2.0/spark-2.2.0-bin-hadoop2.7.tgz

sudo tar xvf spark-2.2.0-bin-hadoop2.7.tgz

/opt/spark-2.2.0-bin-hadoop2.7/bin/run-example SparkPi 10

######################################################

https://github.com/Zhuinden/spring-spark-example

######################################################

docker build -t custom/spark .

######################################################

https://github.com/gettyimages/docker-spark

######################################################

https://radanalytics.io/assets/my-first-radanalytics-app/sparkpi-java-spring.html

######################################################

https://spark.apache.org/docs/latest/rdd-programming-guide.html

#########################################################################

https://github.com/faizanahemad/spark-gradle-template.git

./spark-submit --class com.skb.nads.SampleSpark /home/whilemouse/git/spark/spark-job/sample-spark-1.0.0.jar

./spark-submit --class com.example.demo.Application /home/whilemouse/git/spark/spark-job/spark-sample-0.0.1-SNAPSHOT.jar

cp /home/whilemouse/git/spring-boot-spark-practice/spark-sample/build/libs/spark-sample-0.0.1-SNAPSHOT.jar ./



./spark-submit --class com.example.demo.Main /Users/ksb/Documents/git/spring-boot-spark-practice/spark-sample/build/libs/spark-sample-0.0.1-all.jar
./spark-submit --class template.spark.Main /Users/ksb/Documents/git/spring-boot-spark-practice/spark-gradle-template/build/libs/spark-gradle-template-1.0-SNAPSHOT-all.jar
