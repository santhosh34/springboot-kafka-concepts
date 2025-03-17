
# Spring Boot with Kafka - How to Send 2 diff type of Java Objects within the Same class. 

## Objective


## Repo Usage Guide

### 1. Start all the containers using docker compose
```shell
$ cd pwd
$ pwd
    pwd
$ docker compose up -d
```
Above command will start the following containers
- Kafka
- Zookeeper

### 2. Create a topic

$ docker compose ps
NAME             IMAGE                 COMMAND                  SERVICE           CREATED         STATUS         PORTS
kafkalocaldock   apache/kafka:latest   "/__cacert_entrypoin…"   kafka-doc-local   2 minutes ago   Up 2 minutes   0.0.0.0:9092->9092/tcp


$ docker exec -it -w /opt/kafka/bin  kafkalocaldock  sh    ( Here Kafka is container Name)

Inside Docker:
/opt/kafka/bin $ ./kafka-topics.sh --create --topic my-json-topic    --bootstrap-server kafkalocaldock:29092
                    Created topic my-json-topic.
/opt/kafka/bin $ ./kafka-topics.sh --create --topic my-json-topic    --bootstrap-server kafkalocaldock:29092
Created topic my-byte-array-topic.
/opt/kafka/bin $ ./kafka-topics.sh --list                       --bootstrap-server kafkalocaldock:29092
/opt/kafka/bin $ ./kafka-topics.sh --delete --topic my-topic    --bootstrap-server kafkalocaldock:29092

### 3. Sample Producing Messages
$ docker exec -it -w /opt/kafka/bin  kafkalocaldock  sh    ( Here Kafka is container Name)
Inside Docker:
/opt/kafka/bin $ ./kafka-console-producer.sh  --topic my-topic --bootstrap-server kafkalocaldock:29092

### 3. Consuming Messages from beginning
$ docker exec -it -w /opt/kafka/bin  kafkalocaldock  sh    ( Here Kafka is container Name)
Inside Docker:
/opt/kafka/bin $ ./kafka-console-consumer.sh --topic my-topic --from-beginning --bootstrap-server kafkalocaldock:29092

Ref: 
    1)  https://developer.confluent.io/confluent-tutorials/kafka-on-docker/#set-up
    2)  https://docs.confluent.io/kafka/operations-tools/topic-operations.html

Spring boot kafka Producer:


Spring boot kafka Consumer:

