# Use an official OpenJDK 21 image as the base image
FROM eclipse-temurin:21-jdk

# Set JAVA_OPTS environment variable
ENV JAVA_OPTS="-XX:UseSVE=0"

# Create a wrapper script for /opt/java/openjdk/bin/java
RUN echo '#!/bin/bash\nexec /opt/java/openjdk/bin/java $JAVA_OPTS "$@"' > /usr/local/bin/java && \
    chmod +x /usr/local/bin/java

# Ensure the wrapper script is applied by default
ENV PATH="/usr/local/bin:$PATH"

# Install additional tools if needed (e.g., git, curl)
RUN apt-get update && apt-get install -y \
    git \
    curl \
    && apt-get clean && rm -rf /var/lib/apt/lists/*