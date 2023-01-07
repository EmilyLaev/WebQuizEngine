package engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//The main class of a Spring Boot application
@SpringBootApplication
public class WebQuizEngine {

    //The entry point of the application.
    //Launches the application, creating the beans and starting the embedded Tomcat server.
    public static void main(String[] args) {
        SpringApplication.run(WebQuizEngine.class, args);
    }
}
