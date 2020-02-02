# Spring Boot Kafka Producer Example

To execute this project, it is necessary to have the docker and maven installed on your machine.

## Start docker container

- `docker-compose -f docker-kafka.yml up`

This command responsible to create a kafka and zookeeper container

## Publish message via Rest
- `http://localhost:8081/kafka/publish/`

For monitoring message...could you use

- `https://www.conduktor.io/download`
