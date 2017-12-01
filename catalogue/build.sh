#!/usr/bin/env bash
mvn package -DskipTests
docker build -t cataloge-service .
