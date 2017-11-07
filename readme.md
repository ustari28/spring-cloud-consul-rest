# Spring cloud consul
- Example that implements spring cloud consul with key/value store and set up a watcher with @RefreshScope. It's 
necessary install consul server and create key/value PREFIX/APPLICATION_NAME/KEY according name of data-key by 
default it's data.
- Using RestTemplate we use A.P.I. Rest Consul for getting remote properties.

## Run application
We add support for Java9, so for running application it's necessary add to execution command line the option ```--add-modules java.xml.bind```
## Install consul
```
docker run -d --name my-consul -p 8300:8300 -p 8301:8301 -p 8302:8302 -p 8600:8600 -p 8500:8500 consul
```
## Notes
List of mandatory properties that must be created to consult server:
```
consul.example.value=testactualizado
resource.path=templates/
fecha.actualizacion=20170723
```
The path to property is configuration/spring-consul/application
