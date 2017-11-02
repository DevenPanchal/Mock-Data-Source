## Supported Methods and Objects

The micro service methods and objects are documented using Swagger. A runtime orchestrator server documents itself at a URL like the following, but consult the server's application.properties file for the exact port number ("8555") and context root ("ro") in use:

	http://localhost:8555/ro/swagger-ui.html

## Build Prerequisites

The build machine needs the following:

1. Java version 1.8
2. Maven version 3
3. Connectivity to Maven Central (for most jars)


## Build and Package

Use maven to build and package the service into a single "fat" jar using this command:

	mvn clean install

## Launch Prerequisites

1. Java version 1.8
2. A valid application.properties file.
