# ocjdbc
OpenCensus instrumented JDBC wrapper for tracing and metrics

## Recorded metrics

Metric|Search suffix|Additional tags
---|---|---
Number of Calls|"java.sql/client/calls"|"method", "error", "status"
Latency in milliseconds|"java.sql/client/latency"|"method", "error", "status"
