```
docker pull (image_name:tag)
```

> downloads docker image in local 

```
docker images == docker image ls
```

> Displays all docker images downloaded in local

```
docker run <image_id>
```

> creates a docker container from specified imafe

```
docker container ls
```

> Displays only running containers

```
docker ps -a
```

> Displays all containers either running or exited

```
docker start <container_id>
```

> Starts a container

```
sudo docker exec -it <container_id> /bin/bash
```

> Gets inside the container and allows us running a command inside container shell

```
sudo docker stop <container_id>
```

> Stops a running container

```
sudo docker rm <container_id>
```

> Removes the running container
