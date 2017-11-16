#!/usr/bin/env bash

# 1. Perform checkout request

basket_uuid=$(curl --request POST \
  --url http://localhost:8081/checkouts \
  --header 'content-type: application/json' \
  --cookie JSESSIONID=8ED36E6FF6B5061C680177D7358E1864 \
  --data '{
  "customer": "41440721-19db-4a02-8fd8-b6a0f3427d46",
  "items": [
    {
      "article": "cab08236-1924-4f90-975d-9e056ed14c48",
      "quantity": 300
    },
    {
      "article": "d996413a-21fb-4c12-b4a8-64996876505b",
      "quantity": 3
    }
  ]
}' | jq -r .basket)

if (($? != 0 )); then
    echo "Checkout failed"
    exit
fi

# 2. Perform rating request

curl --request POST \
  --url "http://localhost:8082/payments/$basket_uuid" \
  --header 'content-type: application/json' \
  --cookie JSESSIONID=8ED36E6FF6B5061C680177D7358E1864 \
  --data '{
	"method": "CC"
}'