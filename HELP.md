# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.test..product' is invalid and this project uses 'com.test.product' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


### Preguntas teóricas
1. Los microservicios son servicios pequeños y autónomos, mientras que los servicios web son cualquier servicio que esté disponible a través de Internet. 
2. REST es una arquitectura que se ejecuta a traves de peticiones HTTP (GET,POST,PUT,DELETE,ETC...).
RESTful hacer referencia a un servicio web que implementa la arquitectura REST.
3. La inyección de dependencias es un patrón de diseño en el que se suministran objetos a una clase en lugar de ser la propia clase la que cree dichos objetos.


### Configuracion ambiente local
Para la configuración del ambiente local, se debe tener en cuenta que el proyecto se genera como un proyecto Maven y sus dependencias principales son las de springBoot
para el manejo de sus anotaciones principales y el levantamiento del proyecto como para el desarrollo de los servicios. Asimismo, la dependencia springWeb para el manejo de sus anotaciones
y principalmente el manejo del patrón MVC.

Al generar el proyecto debemos tener en cuenta los paquetes principales que nos darán el estatus y el orden general del proceso y la creación de los servicios.

Los paquetes principales son:

Package Controller: Para el manejo de clases controladoras y configuraciones de los path de los servicios a implementar.
Package Services: Para toda la funcionalidad y la lógica que se va a entregar en los servicios.
Package DAO/Repository: Para todo lo relacionado con las consultas y el modelo de datos que se está presentando en el proyecto.

Springboot por defecto realiza un levantamiento de un pequeño servidor Tomcat para correr los servicios del proyecto.
 




