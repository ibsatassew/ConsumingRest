# Calling a Restful Service

This project demonstrates how to call a RESTful service using a client application. The client application is containerized and can be deployed on Kubernetes.

## Prerequisites

Before running the client application, make sure you have the following prerequisites installed:

- Docker
- Kubernetes
- kubectl
- Java Development Kit (JDK)
- Maven

## Setting up the Quoters Service

To test the RESTful communication, ensure that the Quoters Restful service is running on Kubernetes. You can deploy the Quoters service with the following commands:

kubectl run quoters --image=javajon/quoters:1.0.0 --port=8080
kubectl expose pod quoters --name=quoters
kubectl get all -l run=quoters

### Building and Running the Client on Kubernetes

To deploy the client application on Kubernetes, follow these steps:

1. Build the Docker image:

   docker build -t name/consumingrest .

### Building and Running the Client on Kubernetes

To deploy the client application on Kubernetes, follow these steps:

2. Push the Docker image to a container registry::

docker push name/consumingrest

3. Deploy the client application on Kubernetes:::

kubectl run consumingrest --image=name/consumingrest --env="quoters_base_url=http://quoters:8080"

4. Verify the connection by inspecting the logs of the pod::::

kubectl logs consumingrest
