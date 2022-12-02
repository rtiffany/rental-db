# rental-db

A JavaFX based database front end.

## Development Environment

### Ubuntu 22.04 Virtual Machine

* IntelliJ IDE `sudo snap install intellij-idea-community --classic`
* Scenebuilder (.deb package from website)
* Mariadb Client `sudo apt install mariadb-client`
* Git

Connect remotely

````shell
mysql -h 45.76.5.38 -P 3306 --protocol=tcp -u rentaldb -p
````

### Cloud Debian 11 Database Server

Hosted on Vultr, however I'm indifferent to cloud provider

`apt install docker.io mariadb-client`

Pull docker image

`docker pull mariadb`

Create docker container (todo: docker-compose .yaml)

```
docker run \
  --detach \
  --name rentaldb-maria \
  -v /var/lib/mysql:/var/lib/mysql \
  -p 3306:3306 \
  -e MARIADB_USER=username \
  -e MARIADB_PASSWORD=password \
  -e MARIADB_ROOT_PASSWORD=password \
  mariadb:latest
```

login locally
`mysql -P 3306 --protocol=tcp -u root -p`

