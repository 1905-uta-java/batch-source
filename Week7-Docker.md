## Example Docker Commands
> docker info

> docker build (-t [tag name]) [loc Dockerfile]
    > docker build -t discovery-service .

> docker images 

> docker rmi

> docker run (-d) (-p [host port]:[container port]) [image tag or id] 
    > docker run -d -p 8761:8761 discovery-service

> docker ps

> docker kill [image id, only first few chars needed]
    > docker kill 8d7e

#### Interacting with Docker Hub
> docker login --username=[username] --password-std

> docker pull [image]

> docker push [image]

### Docker Swarm 
> docker swarm init --advertise-address [manager ip]

> docker swarm join --token [token from manager] [advertised address]:[advertised port - default 2377]

> docker node ls

> docker service create (--replicas [#]) (--name [name]) [image]
    > docker service create --replicas 3 --name account-docker-service crehm/account-service:1905

> docker service inspect [service]

> docker service ps [service]

> docker service scale [service]=[num of replicas]
    > docker service scale account-docker-service=5

> docker service rm [service]

> docker node inspect [node]

> docker node rm [node]

> docker node ps [node]

> docker swarm leave
 

#### For an exhaustive list of Docker commands see 
https://docs.docker.com/engine/reference/commandline/cli/