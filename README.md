# Performance of Java 8 Streams

This project was used to experiment with measuring performance of Java 8 streams. It contains various implementations
computing max value over large array using both functional and imperative style. Performance tests are executed using
the JMH tool.

## Building

    ./gradlew clean build

## Running performance tests

    ./gradlew jmh

Results are avaiable in

    build/reports/jmh/

