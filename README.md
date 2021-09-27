![](./img/kubernetes-docker.svg)

## [spring-boot-mysql-k8s-demo](#spring-boot-mysql-k8s-demo)

Run spring boot application and mysql on kubernetes cluster

## [Prerequisite](#Prerequisite)
* Docker and kubernetes cluster
* kubectl
* Jdk 1.8

## [Compilation command](#compilation-command)
mvn clean package -DskipTests

## [Build Docker image](#build-docker-image)
docker build -t spring-boot-mysql-k8s-demo:1.0 .

## [Verify image creation](#verify-image-creation)
docker image ls

## [Create kubernetes objects for spring-boot app and mysql database](#create-k8s)
These files will be available under deploy folder and need to be executed sequentially.

```kubectl apply -f mysql-credentials.yml```

```kubectl apply -f mysql-root-credentials.yml```

```kubectl apply -f mysql-configmap.yml```

```kubectl apply -f mysql-deployment.yml```

```kubectl apply -f spring-boot-deployment.yml```

## [Verify deployment objects](#verify-deployment-objects)


To verify all deployment objects running:

```kubectl get all -o wide```

Spring boot app log verification:

```kubectl logs -f <podName>```

```Eg: kubectl logs -f spring-boot-mysql-k8s-demo-6444f95584-mfvnz```

## [Verify mysql container and connectivity](#Verify-mysql-container)

Navigate inside mysql container:

```kubectl exec -it <podName> bash```

```Eg: kubectl exec -it mysql-795b8d8fbb-6mjxl bash```

Provide credentials:

```mysql -h mysql -u testuser -p```

Enter DB password as: testuser@123

Execute sql commands:

```show databases;```

```use test;```

```show tables;```

```select * from user;``` -> This will return empty records as we have not inserted any data yet

uninstall