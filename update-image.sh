#!/bin/bash
cd dockerfiles
docker build -t jenkins-image:latest .
cd ..

docker compose up -d