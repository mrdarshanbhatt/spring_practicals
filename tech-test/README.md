🎉# Project Guide
### Reference Documentation
This Spring Boot Project build for Learning purpose

* In this project creating the rest API for CRUD Operation of Favourite Country and also call third-party API of Restcountries.
* restcountries provide the whole world data related to country-state-capital and many more You can visit [Here](https://restcountries.com/) for more info. 
* All the API is Secured with Spring Security and also configure the Swagger & Docker.

### Project Setup
* Download the zip file from Github or simply clone the project from the git.
* Run in IDE then simply run as Spring boot App from the STS of IntelliJ
* Run using Docker then first build project using **mvn clean install -DskipTests** (Docker Step Mentioned below)

### Docker Image Guide
Below Step Explain the How to create docker image, run and push on **Docker HUB**

* Build Docker Image: docker build -t imageName:TagName
* Run Docker Image  : docker run -p 8080:8080 -it imageName:TagName
* Tagged the image  : docker tag username/imagename:latest localImageName:localImageTag
* Push Image on Docker : docker push username/imagename:latest

