# CLI Installation

# Not specified in docs why:

docker network create jenkins


# Because there is not DIND:

```bash
docker run --name jenkins-docker --rm --detach \
  --privileged --network jenkins --network-alias docker \
  --env DOCKER_TLS_CERTDIR=/certs \
  --volume jenkins-docker-certs:/certs/client \
  --volume jenkins-data:/var/jenkins_home \
  --publish 2376:2376 \
  docker:dind --storage-driver overlay2
```

# To build the image:

(This is not used:)
```bash
docker build -t myjenkins-blueocean:2.462.2-1 .
```

But since this is the first image, I would call it:

(This is used:)
```bash
docker build -t -jenkins:0.0.1 .
```

# Running the image:

```bash
docker run \
  --name -jenkins \
  --restart=on-failure \
  --detach \
  --network jenkins \
  --env DOCKER_HOST=tcp://docker:2376 \
  --env DOCKER_CERT_PATH=/certs/client \
  --env DOCKER_TLS_VERIFY=1 \
  --publish 8080:8080 \
  --publish 50000:50000 \
  --volume jenkins-data:/var/jenkins_home \
  --volume jenkins-docker-certs:/certs/client:ro \
  -jenkins:0.0.1
  ```

  # Get password:

```bash
  docker logs -jenkins
```