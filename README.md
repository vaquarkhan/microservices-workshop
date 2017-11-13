# kafkacat

    $ https://github.com/edenhill/kafkacat

# Kafka Docker Image

    $ docker run --rm -d -e ADVERTISED_HOST=localhost -p 2181:2181 -p 9092:9092 --env ADVERTISED_PORT=9092 --name kafka -h kafka spotify/kafka