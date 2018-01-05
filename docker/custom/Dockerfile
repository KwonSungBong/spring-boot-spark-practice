FROM ubuntu:14.04
RUN apt-get update && apt-get install -y wget zip unzip
RUN apt-get update && apt-get -y upgrade && apt-get -y install software-properties-common && add-apt-repository ppa:webupd8team/java -y && apt-get update
RUN (echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections) && apt-get install -y oracle-java8-installer oracle-java8-set-default

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
ENV PATH $JAVA_HOME/bin:$PATH

RUN cd /opt/
RUN wget http://apache.mirror.cdnetworks.com/spark/spark-2.2.0/spark-2.2.0-bin-hadoop2.7.tgz
RUN sudo tar xvf spark-2.2.0-bin-hadoop2.7.tgz

#VOLUME /opt/spark-2.2.0-bin-hadoop2.7
