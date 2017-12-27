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