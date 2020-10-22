## Running Application
- install java version 8
- either:
    - install maven
        - <code>mvn clean package</code>
    - use maven wrapper
        - <code>./mvnw clean package</code>      
- retrieve custom-spring-boot-servlet-initializer-war.war file from target/ directory
- place it into tomcat's libexec/webapps
- start/restart tomcat server
- open browser: http://localhost:8080/custom-spring-boot-servlet-initializer-war
- if you see `hello world` then success!

## Confluence Article
- [http://confluence.marcuschiu.com/article](http://confluence.marcuschiu.com/display/NOT/Java+-+Spring+-+Application+Context+-+ServletContextInitializer)