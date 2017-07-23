#Spring cloud consul
- Example that implements spring cloud consul with key/value store and set up a watcher with @RefreshScope. It's 
necessary install consul server and create key/value PREFIX/APPLICATION_NAME/KEY according name of data-key by 
default it's data.
- Using RestTemplate we use A.P.I. Rest Consul for getting remote properties.
##Install consul
```
docker run -d --name dev-consul -p 8300:8300 -p 8301:8301 -p 8302:8302 -p 8600:8600 -p 8500:8500 consul
```