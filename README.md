# docker-compose
Docker compose deployment tool with example
<table>
  <tr>
   <td>
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
