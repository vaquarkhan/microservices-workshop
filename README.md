# kafkacat

    $ https://github.com/edenhill/kafkacat

## Read messages from Kafka 'stock' topic, print to stdout

    ./kafkacat -b localhost:9092 -t shop

## Produce messages from stdin

    ./kafkacat -P -b localhost:9092 -t shop

## Produce messages from file

    ./kafkacat -P -b localhost:9092 -t shop -p 0 *.json

## Get metadata listing

    ./kafkacat -L -b localhost:9092

# Kafka Docker Image

    docker run --rm -d --name kafka -e ADVERTISED_HOST=localhost -p 2181:2181 -p 9092:9092 --env ADVERTISED_PORT=9092 --name kafka -h kafka spotify/kafka
    docker rm -f kafka