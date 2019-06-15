FROM openjdk:8-jre-slim

#A Directory in the base image to copy our dependencies
WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/Test-Assignment-Simple-1.0-SNAPSHOT.jar Test-Assignment-Simple-1.0-SNAPSHOT.jar
ADD  target/libs libs

# Command line to execute the test
# Expects below ennvironment variables
# BROWSER = chrome / firefox
# MODULE  = order-module / search-module
# SELENIUM_HUB = selenium hub hostname / ipaddress

ENTRYPOINT java -jar libs/junit-platform-console-standalone-1.4.2.jar -cp Test-Assignment-Simple-1.0-SNAPSHOT.jar --scan-classpath