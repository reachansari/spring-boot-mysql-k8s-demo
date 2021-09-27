![](./img/kubernetes-docker.svg)
# spring-boot-mysql-k8s-demo

Run spring boot application and mysql on kubernetes cluster

## [Maven Changes]

mysql -h mysql -u testuser -p
pwd: testuser@123

show databases;

use test;

show tables;

Compilation command:
mvn clean package -DskipTests

Build Docker image
docker build -t spring-boot-mysql-k8s-demo:1.0 .

verify image creation
>docker image ls

kubectl apply -f mysql-credentials.yml
kubectl apply -f mysql-root-credentials.yml
kubectl apply -f mysql-configmap.yml
kubectl apply -f mysql-deployment.yml
kubectl apply -f spring-boot-deployment.yml

>kubectl get all -o wide

kubectl logs -f spring-boot-mysql-k8s-demo-6444f95584-mfvnz

kubectl exec -it mysql-795b8d8fbb-6mjxl bash

mysql -h mysql -u testuser -p
pwd: testuser@123

show databases;

use test;

show tables;

select * from user;

uninstall