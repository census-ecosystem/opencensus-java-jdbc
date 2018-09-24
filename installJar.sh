#!/bin/sh
mvn install && mvn install:install-file -Dfile=$(pwd)/target/ocjdbc-0.0.1.jar \
    -DgroupId=io.opencensus -DartifactId=ocjdbc -Dversion=0.0.1 \
    -Dpackaging=jar -DgeneratePom=true
