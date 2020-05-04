# docker-compose
Docker compose deployment tool with example
<table style="border:none;">
  <tr style="border:none;">
   <td style="border:none;">
     <ul>
       <li>
         <b> Microservices </b>  is popular for building large-scale applications and breaking down one large application into a
         collection of smaller component.  Docker is an excellent tool for managing and deploying microservices
       </li>
       <br/>
       <li>
       <b> Docker </b> is an open source containerization platform for building application based on container. 
       </li>
       <br/>
       <li>
         <b> Dockerfile </b> is a list of commands that Docker Engine will run in order to assemble the image.  A Dockerfile adheres 
           to a specific format and set of instructions which you can find at 
           <a href="https://docs.docker.com/engine/reference/builder/">Dockerfile reference </a>
       </li> 
       <br/>
       <li>
       <b> Docker </b> images contain executable application source code as well as all the tools, libraries, and dependencies. 
         When you run the Docker image, it becomes one instance of the container
       </li>
       <br/>
      <li>
        <b> Docker </b> container is running instance of docker image. Every container running is isolation from one another
      </li> 
       <br/>
      <li>
        <b>Docker Hub </b> is the public repository of docker images from where developer can download all opensource images and 
        create their own private repository to store docker images
      </li> 
     </ul>
       </td>
     </tr>
  </table>
<br/>
<strong> Deployment of Services on Docker </strong>
<br/><br/>
Running only a few containers is fairly simple to manage application within Docker Engine itself. But if deployment comprises many containers and services then it difficult to managed for developer without the help of these tdocker compose and kubernetes tools
<br/><br/>
<strong> Docker Compose </strong> <br/><br/>
Docker compose is a tool for defining and running multi-container Docker applications that all reside on the same host. Docker Compose creates a YAML file that specifies which services are included in the application, and can deploy and run containers with a single command
<br/><br/>
<strong> Prerequisites </strong><br/><br/>
<ul>
  <li>Make sure you have already installed both <a href="https://docs.docker.com/get-docker/"> Docker Engine </a> and 
    <a href="https://docs.docker.com/compose/install/" />Docker Compose </a> </li>
  <li> Verify installation using </br> $ docker-compose --version </li>
</ul>

<br/>
<br/>
  
<strong> let's get started deployment </strong>
  
  <table>
    <tr>
      <td>
        <ul>
          <li>
          <b>  Step 1: </b>
            <br/><br/> &nbsp;&nbsp; Create a java application or clone current docker-compose springboot application <br/>
             &nbsp;&nbsp; $ git clone https://github.com/malam84/docker-compose.git <br/>
             &nbsp;&nbsp; $ cd docker-compose <br/>
             &nbsp;&nbsp; Create a text Dockerfile and yaml docker-compose inside project root directory <br/>
          </li>
          <br/> 
          <li>
            <b> Step2: Configure Dockerfile </b>
            <br/> <br/> &nbsp;&nbsp; Common Dockerfile instructions start with  RUN, ENV, FROM, MAINTAINER, ADD, and CMD, among others
              <br/> <br/>
                <ul>
                    <li>
                      <b> FROM </b> - Specifies the base image that the Dockerfile will use to build a new image
                    </li>
                    <li>
                      <b> MAINTAINER </b> - Specifies the Dockerfile Author Name and his/her email
                    </li>
                    <li>
                    <b> RUN </b> - Runs any UNIX command to build the image
                    </li>
                    <li>
                    <b>	ENV </b> - Sets the environment variables
                    </li>
                    <li>
                      <b> CMD </b> - Provides the facility to run commands at the start of container. This can be overridden upon
                      executing the docker run command
                    </li>
                    <li>
                      <b> ADD </b> - This instruction copies the new files, directories into the Docker container file system at 
                      specified destination
                    </li>
                    <li>
                      <b> EXPOSE </b> - This instruction exposes specified port to the host machine
                    </li>
                     <br/><br/>
                    <li>
                       <b>  Dockerfile is: </b>
                     <br/><br/><br/>
                     /*******************   Dockerfile.txt **********************************/ <br/><br/>
                      # Start with a base image containing Java runtime <br/>
                        FROM java:8 <br/><br/>
                      # Add Maintainer Info<br/>
                        LABEL maintainer="malam84@gmail.com"
                      <br/> <br/>
                      # Add a volume pointing to /tmp<br/>
                        VOLUME /tmp
                      <br/>
                       <br/>
                     # Make port 8084 available to the world outside this container <br/>
                       EXPOSE 8084 <br/><br/>
                     # Add the application's jar to the container <br/>
                       ADD /target/docker-compose.jar docker-compose.jar <br/><br/>
                     # Run the jar file <br/>
                       ENTRYPOINT ["java", "-jar", "docker-compose.jar"] <br/>
                  <br/><br/>
                      /*************************************************************/ <br/><br/>
                  </li>     
                </ul>
             </li>
          <li> <b> Step 3: Configure docker compose file </b> 
                <br/> <br/> &nbsp;&nbsp; Define services in a compose file. 
                Please <a href="https://docs.docker.com/compose/compose-file/"> refere </a> for more detail
                <br/>
                <br/>
            
 /***************************** docker-compose.yml *********************************/ <br/>
                <br/>
version : '3.6' <br/><br/>

services: <br/>
&nbsp;&nbsp;  mysql-server: <br/>
 &nbsp;&nbsp;&nbsp;&nbsp;   image: mysql/mysql-server:latest <br/>
 &nbsp;&nbsp;&nbsp;&nbsp;   container_name: mysql-server <br/>
&nbsp;&nbsp; &nbsp;&nbsp;   ports: <br/>
  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;   - "3306:3306" <br/>
  &nbsp;&nbsp; &nbsp;&nbsp; environment:<br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   MYSQL_USER: root <br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   MYSQL_PASSWORD: password <br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   MYSQL_ROOT_PASSWORD: password <br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   MYSQL_DATABASE: mydb <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  MYSQL_ROOT_HOST: 192.168.99.100 <br/>
    &nbsp;&nbsp;&nbsp;&nbsp; restart: always <br/>
 
 &nbsp;&nbsp; phpmyadmin: <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;  image: phpmyadmin/phpmyadmin <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;  container_name: myphpadmin <br/>
 &nbsp;&nbsp;&nbsp;&nbsp; depends_on: <br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   - mysql-server <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;  environment: <br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   PMA_HOST: mysql-server <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    PMA_PORT: 3306 <br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   MYSQL_ROOT_PASSWORD: password <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;restart: always <br/>
   &nbsp;&nbsp;&nbsp;&nbsp; ports: <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  - 8080:80 <br/>
  
  &nbsp;&nbsp; docker-compose-app: <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;   image: docker-compose <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;  build: <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    context: ./ <br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   dockerfile: Dockerfile <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;  ports: <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   - 8084:8084 <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;  environment: <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  SPRING_DATASOURCE_URL: jdbc:mysql://mysql-server:3306/mydb?autoReconnect=true&useSSL=false &allowPublicKeyRetrieval=true
   <br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  FLYWAY_URL: jdbc:mysql://mysql-server:3306/mydb?autoReconnect=true&useSSL=false& allowPublicKeyRetrieval=true <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;
    depends_on: <br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   - mysql-server <br/> <br/> <br/> 
    /**************************************************************************************************/
          </li>
          <br/> <br/> 
        <li>
  <b> Step 4:  Build and run your application </b><br/><br/>
               &nbsp;&nbsp; docker-compose up </br>
               &nbsp;&nbsp; docker-compose down </br>
        </li>
        </ul>
     </td>
    </tr>
  </table>
  
