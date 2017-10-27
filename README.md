# Apache Kafka cluster with Docker

This project demonstrates how to create a Kafka cluster using Docker containers.

It also contains sample producers and consumers.

## Building

The Docker image can be built using the command:

    $ docker build -t bdorville/kafka socker/kafka-node

## Running

A Docker compose file is provided as a starting point to launch a simple *single-node* cluster. Running should be done as a background daemon.