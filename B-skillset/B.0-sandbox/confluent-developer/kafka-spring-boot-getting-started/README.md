source link: (Geting Started with Apache Kafka and Spring Boot)[https://developer.confluent.io/get-started/spring-boot/]

Setup:
2 options to run your first kafka application
a. using Confluent Cloud, sign up, avoid cc add promo code `CONFLUENTDEV1`.
b. setup a local Kafka cluster.

Prerequisite:
a. Gradle installed
b. Java 17

Create Project:
a. make directory
b. create build.gradle (followed + copied)

Kafka Setup:
a. create a Kafka cluster located at local
b. Install the Confluent CLI via brew
c. start the kafka broker (note the plaintext ports to place it in bootstrap-servers)

COnfiguration:
a. Create a directory for the application resource file (src/main/resources/application.yaml)
b. Replace bootstrap-servers: localhost:<PLAINTEXT PORTS> to bootstrap-servers: localhost:54755
c. 

Create Topic:
a. A topic is an immutable, append-only log of events
b. Create a new topic, purchases, which you will use to produce and consume events 

Build Producer:
a. Create a directory for the Java files in this project
b. compile the code with `./gradlew build` and not with `gradle build` (Build Failed: Follow Gradle Build Troubleshooting Notes)



---

# Gradle Build Troubleshooting Notes

While following the Confluent “Getting Started with Apache Kafka and Spring Boot” guide, the project failed when running:

```bash
gradle build
```

## Initial Error

The first failure was:

```text
Could not find method jcenter() for arguments [] on repository container
```

This happened because the project was being built with the globally installed Gradle version:

```text
Gradle 9.5.1
```

The tutorial project used older Gradle configuration that referenced `jcenter()`, which is no longer supported in modern Gradle versions.

## Fix 1: Replace `jcenter()`

The `build.gradle` file was updated to use:

```gradle
mavenCentral()
```

instead of:

```gradle
jcenter()
```

The Confluent Maven repository was kept because the project depends on Confluent/Kafka artifacts:

```gradle
maven {
  url 'https://packages.confluent.io/maven'
}
```

## Fix 2: Use a Gradle Wrapper

After fixing `jcenter()`, the build still failed because Spring Boot `3.2.3` was not fully compatible with Gradle 9.

A project-local Gradle wrapper was generated using Gradle `8.7`:

```bash
gradle wrapper --gradle-version 8.7 --distribution-type bin
```

From this point forward, the project should be built with:

```bash
./gradlew build
```

instead of:

```bash
gradle build
```

This ensures the project always uses the compatible Gradle version defined by the wrapper.

## Fix 3: Java Version Compatibility

The machine had JDK 21 installed, but not JDK 17. Since the Spring Boot project targets Java 17, the build was configured to compile Java 17-compatible bytecode using the installed JDK:

```gradle
java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType(JavaCompile).configureEach {
  options.release = 17
}
```

## Final Result

The build succeeded with:

```bash
./gradlew build
```

Output:

```text
BUILD SUCCESSFUL
```

## Key Lesson

For tutorial or sample projects, prefer using the project’s Gradle wrapper:

```bash
./gradlew build
```

instead of a globally installed Gradle version.

The wrapper keeps the build tied to a known-compatible Gradle version and avoids errors caused by newer Gradle releases.

---

zsh - Export As Text - see the file:
Confluent_Developer_GettingStartedWithApacheKafkaAndSpringBoot_Terminal Saved Output.txt
