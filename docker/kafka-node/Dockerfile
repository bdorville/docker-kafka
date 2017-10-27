FROM openjdk:jdk-alpine

LABEL maintainer="bdorville+github.com@gmail.com"

ENV KAFKA_VERSION 0.11.0.1
ENV KAFKA_SCALA_VERSION 2.11
ENV KAFKA_HOME /usr/kafka_${KAFKA_SCALA_VERSION}-$KAFKA_VERSION

RUN apk update && apk upgrade && \
    apk add curl bash openssl unzip tar && \
    rm -rf /var/cache/apk/* && \
    echo "Downloading Apache Kafka" && \
    curl -L "http://mirror.switch.ch/mirror/apache/dist/kafka/$KAFKA_VERSION/kafka_$KAFKA_SCALA_VERSION-$KAFKA_VERSION.tgz" -o kafka.tgz && \
    echo "Extracting Kafka" && \
    tar -zxf kafka.tgz -C /usr/ && \
    echo "Cleaning up Kafka tmp files" && \
    rm kafka.tgz && \
    chown -R root:root $KAFKA_HOME

ADD server.properties $KAFKA_HOME/config/kafka-server.properties

WORKDIR $KAFKA_HOME
CMD ["bin/kafka-server-start.sh", "config/kafka-server.properties"]
