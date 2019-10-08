# 02-microservices-individual-tasks-nicoVasq

#### Config:

```
quarkus.http.port=8090
%dev.quarkus.http.port=8091
at.htl.BarbershopService/mp-rest/url=http://localhost:8080/api
at.htl.BarbershopService/mp-rest/scope=javax.inject.Singleton
```



### Prometheus

[Prometheus](https://github.com/prometheus) is an systems monitoring and alerting toolkit. Prometheus stores data as **time series**: streams of timestamped values belonging to the same metric and the same set of labeled dimensions. Every time series is uniquely identified by its *metric name* and optional key-value pairs called *labels*. The time series collection happens via a pull model over HTTP and there are also multiple modes of graphing and dashboarding support. 

In a world of microservices, its support for multi-dimensional data collection and querying is a particular strength.

### Istio

Istio makes it easier to develop and operate monolithic applications towards a distributed microservice architecture. Istio provides behavioral insights and operational control over the service mesh as a whole.

The term service mesh is used to describe the network of microservices that make up such applications and the interactions between them. As a service mesh grows in size and complexity, it can become harder to understand and manage