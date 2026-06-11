# spring-time

A Spring Boot POC project combining multiple Spring guides into a single application for hands-on learning.
Changes validated here are promoted to `3-backend/life-log-man-spring`.

> Some changes in this project are intentionally exploratory and messy — that's the point of a sandbox POC.

References:
- https://spring.io/guides/gs/spring-boot
- https://spring.io/guides/gs/spring-boot-docker
- https://spring.io/guides/gs/securing-web

---

## Overview

This project demonstrates:
- REST API endpoints using `@RestController`
- MVC web pages using Thymeleaf templates
- Spring Security with form-based login and in-memory authentication
- Containerization with Docker

---

## Prerequisites

- Java 21
- Maven (via `./mvnw` wrapper — no install needed)
- Docker Desktop (for running with Docker)

---

## Setup & Installation

```bash
git clone <your-repo-url>
cd spring-time
```

No additional setup required. The Maven wrapper handles all dependencies.

---

## Running Locally

```bash
./mvnw spring-boot:run
```

App starts at `http://localhost:8080`

Verify with curl in a separate terminal:

```bash
curl http://localhost:8080/0
# Greetings from Spring Boot!
```

---

## API Endpoints

### REST Endpoints (`@RestController` — returns plain text)

| Method | URL | Auth Required | Description |
|--------|-----|---------------|-------------|
| GET | `/0` | No | Returns `"Greetings from Spring Boot!"` |
| GET | `/hello0` | No | Returns `"Hello World!"` |
| GET | `/hello0?name=AJ` | No | Returns `"Hello AJ!"` |

### MVC Endpoints (Thymeleaf templates)

| Method | URL | Auth Required | Description |
|--------|-----|---------------|-------------|
| GET | `/1` | No | Home page (`home.html`) |
| GET | `/hello1` | Yes | Hello page (`hello.html`) |
| GET | `/login` | No | Login page |

---

## Security

Spring Security is configured with in-memory authentication for POC purposes.

| Field | Value |
|-------|-------|
| Username | `user` |
| Password | `password` |

Public routes (`/0`, `/hello0`, `/1`, `/login`) are accessible without authentication. `/hello1` requires login and redirects to `/login` if unauthenticated.

---

## Running Tests

Add the following dependency to `pom.xml` for MVC testing:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc-test</artifactId>
    <scope>test</scope>
</dependency>
```

Run tests:

```bash
./mvnw test
```

The test suite covers:

| Test Class | What it tests |
|---|---|
| `SpringTimeApplicationTests` | REST endpoint `/0` returns 200 with correct body |
| `SecuringWebApplicationTests` | Login with valid/invalid credentials, access control for secured and public routes |

Expected output:
```
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

---

## Running with Docker

There are two ways to build a Docker image for this project:

### Option A — Manual Dockerfile build

**1. Build the jar**
```bash
./mvnw clean package -DskipTests
```

**2. Unpack for Docker layers**
```bash
mkdir -p target/dependency
cd target/dependency
jar -xf ../*.jar
cd ../..
```

**3. Build the Docker image**
```bash
docker build -t adamjohndbenitez/spring-time .
```

### Option B — Spring Boot Buildpacks (recommended)

No Dockerfile needed. Spring Boot auto-detects the app and builds the image:

```bash
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=adamjohndbenitez/spring-time
```

---

### Push to Docker Hub

```bash
docker login
docker push adamjohndbenitez/spring-time
```

---

### Run the Container

```bash
docker run --name spring-time -p 8080:8080 adamjohndbenitez/spring-time
```

App is available at `http://localhost:8080`

If port 8080 is already in use (e.g. local Maven is running), map to a different host port:

```bash
docker run --name spring-time -p 9090:8080 adamjohndbenitez/spring-time
```

App is then available at `http://localhost:9090`

To avoid port conflicts, check what is using port 8080 first:

```bash
lsof -i :8080
kill -9 <PID>
```

---

### Stop the Container

```bash
docker stop spring-time
```

### Clean Up Containers

Stopped containers accumulate over time. Use `--rm` during development to auto-delete on stop:

```bash
docker run --rm -p 8080:8080 adamjohndbenitez/spring-time
```

Or manually delete stopped containers via Docker Desktop's trash icon, or:

```bash
docker rm <container-name>
```

---

### Local Maven vs Docker — Key Difference

When running both simultaneously you can observe:

| | Local Maven | Docker Container |
|---|---|---|
| PID in logs | e.g. `10940` | Always `1` |
| Stopped by `Ctrl+C` | ✅ Yes | ❌ No — keeps running |
| Port | 8080 | Configurable via `-p` |

Inside a Docker container, your app runs as **PID 1** — the only process in its isolated environment. Killing your terminal has no effect on it.

---

## Project Structure

```
spring-time/
├── src/main/java/xyz/season/springtime/
│   ├── controller/
│   │   └── HelloController.java       # REST endpoints /0 and /hello0
│   └── secureweb/
│       ├── MvcConfig.java             # MVC routes /1, /hello1, /login
│       └── WebSecurityConfig.java     # Security rules and in-memory user
├── src/main/resources/
│   ├── templates/                     # Thymeleaf HTML templates
│   └── application.yml
├── src/test/java/xyz/season/springtime/
│   ├── SpringTimeApplicationTests.java
│   └── SecuringWebApplicationTests.java
└── Dockerfile
```

---

## Built With

- [Spring Boot 4.x](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Docker](https://www.docker.com/)




## Your Overall Development Workflow
📦 Sandbox 1 — Spring Guides (read-only reference)
Downloaded zipped repos from GitHub
Individual isolated guide projects
e.g. gs-spring-boot-docker, gs-securing-web
↓
↓  POC & experiment
↓
🧪 Sandbox 2 — spring-time (messy, exploratory)
Combine guides together
Try to make them work side by side
Break things, fix things, learn
↓
↓  Only when stable & validated
↓
🚀 Production Codebase — life-log-man-spring
Clean, formal, intentional changes
Promoted from spring-time only when ready

running your own feature branch → staging → production pipeline, just at the learning level.