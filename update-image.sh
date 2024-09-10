#!/bin/bash

# The image name to check for
IMAGE_NAME="jenkins-image:latest"

# Command to run if the container is running
COMMAND="docker compose down -v"

# Check if a container using the image is running
CONTAINER_ID=$(docker ps --filter "ancestor=$IMAGE_NAME" --format "{{.ID}}")


if [ -n "$CONTAINER_ID" ]; then
    echo "Container with image $IMAGE_NAME is running."
    # Run the command
    eval $COMMAND
else
    echo "No container with image $IMAGE_NAME is running."
fi

cd dockerfiles
docker build -t jenkins-image:latest .
cd ..

docker compose up -d || docker-compose up -d