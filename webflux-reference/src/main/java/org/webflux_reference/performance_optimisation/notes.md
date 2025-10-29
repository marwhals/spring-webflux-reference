# Performance Optimisations

---

- gZip - Compress the response before sending it over the network
  - Server requires additional processing to compress
  - May have negative effect when the response size is small
  - Won't be noticed when testing locally. Will need to setup a performance test Jmeter etc.

```yaml
    server.compression.enabled=true
    server.compression.min-response-size=2048
    server.compression.mime-types=application/json,application/xml
```
Client Side Request Header: `Accept-Encoding: gzip` 

---

## Connection Pooling

- Connections take time to setup
- Keep-alive - allows for reuse of connections
- HTTP 1.1 allows for 1 connection per request.
- Webclient - byDefault - will manage 500 connections to a remote service but it is configurable

---

## HTTP 2.0

- Multiplexing
- Binary Protocol
- Header compression
- Might not see benefit of HTTP 2 if we don not have many concurrent requests
- Need to ensure that the load balancer supports HTTP2

---

## `subscribeOn`

- Use when a reactive library cannot be found for blocking IO

```java

import reactor.core.publisher.Mono;

Mono.fromSupplier(() -> yourLib.invokeMethod())
        ...
        .subscribeOn(Schedulers.boundedElastic())

```