#!/usr/bin/env bash

# enable list command
set -x

# Build and install in local Maven repo Jenkins
mvn clean install -DskipTests

# Get name and version fron pom.xml
NAME=$(mvn -q -DforceStdout help:evaluate -Dexpression=project.artifactId)
VERSION=$(mvn -q -DforceStdout help:evaluate -Dexpression=project.version)

# Check if Var exists
JAR_FILE="target/${NAME}-${VERSION}.jar"
if [ ! -f "$JAR_FILE" ]; then
    echo "Error: $JAR_FILE not found!"
    exit 1
fi

# Run app
java -jar "$JAR_FILE"

# disable list command
set +x