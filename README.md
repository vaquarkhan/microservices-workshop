## Requirements

* Docker
* kafkacat
* jq
* bash
* curl

## Kafka Docker Image

    docker run -d --name kafka -e ADVERTISED_HOST=localhost -p 2181:2181 -p 9092:9092 --env ADVERTISED_PORT=9092 --name kafka -h kafka spotify/kafka
    docker rm -f kafka

## kafkacat

    $ https://github.com/edenhill/kafkacat

### Read messages from Kafka 'quantity' topic, print to stdout

    ./kafkacat -b localhost:9092 -t shop

### Produce messages from stdin

    ./kafkacat -P -b localhost:9092 -t shop

### Produce messages from file

    ./kafkacat -P -b localhost:9092 -t shop -p 0 *.json

### Get metadata listing

    ./kafkacat -L -b localhost:9092

## Kafka Docker Image

    docker run --rm -d --name kafka -e ADVERTISED_HOST=localhost -p 2181:2181 -p 9092:9092 --env ADVERTISED_PORT=9092 --name kafka -h kafka spotify/kafka
    docker rm -f kafka
    
## Usage

### Get the list of articles

    GET http://localhost:8084/articles
    
### Checkout some articles

    POST http://localhost:8081/checkout

    Body:

    {
        "customer": "41440721-19db-4a02-8fd8-b6a0f3427d46",
        "items": [
            {
                "article": "cab08236-1924-4f90-975d-9e056ed14c48",
                "quantity": 3
            },
            {
                "article": "d996413a-21fb-4c12-b4a8-64996876505b",
                "quantity": 3
            }
        ]
    }
   
You will get back a basket ID (a UUID).
   
### Carry out payment


    POST http://localhost:8081/checkout/{basket-id}
    
    Body:
    
    {
        "method": "CC", // alternatives are "PayPal"
    }

You will get back a success message (200 OK) or an error (409 Conflict).
