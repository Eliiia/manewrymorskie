# manewrymorskie

Basic Java project scaffold using Maven.

## Project structure

- `src/main/java` - application source code
- `src/test/java` - tests
- `pom.xml` - Maven build configuration

## Quick start

```sh
mvn test
mvn -q exec:java -Dexec.mainClass=App
```

If `exec:java` is unavailable, run:

```sh
mvn -q package
java -cp target/manewrymorskie-0.1.0-SNAPSHOT.jar App
```

