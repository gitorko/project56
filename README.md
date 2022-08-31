# Project 56

Spring & Redis (Messaging + Data)

[https://gitorko.github.io/spring-redis/](https://gitorko.github.io/spring-redis/)

### Version

Check version

```bash
$java --version
openjdk 17.0.3 2022-04-19 LTS
```

### Redis

```bash
docker run --rm --name my-redis -p 6379:6379 -d redis redis-server --requirepass "password"

```

To bring up Redis and UI

```bash
docker-compose -f docker/docker-compose-redis.yaml up
```

Open Redis UI [http://localhost:8081/](http://localhost:8081/)

### Dev

To run the backend in dev mode.

```bash
./gradlew clean build
./gradlew bootRun
```
