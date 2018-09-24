# ocjdbc
OpenCensus instrumented JDBC wrapper for tracing and metrics

## Metrics provided

### Tag keys
Every metric is recorded with the following tags:
* "arch"
* "java_version"
* "os_name"
* "os_version"


### Recorded metrics

Metric|Search suffix|Additional tags
---|---|---
Number of Calls|"java.sql/client/calls"|"method"
Errors|"java.sql/client/errors"|"reason"
Latency in milliseconds|"java.sql/client/latency"|"method"
