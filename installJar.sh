#!/bin/sh
mvn install && mvn install:install-file -Dfile=$(pwd)/target/opencensus-ocjdbc-0.0.2.jar \
    -DgroupId=io.opencensus.integration -DartifactId=opencensus-ocjdbc -Dversion=0.0.2 \
    -Dpackaging=jar -DgeneratePom=true
