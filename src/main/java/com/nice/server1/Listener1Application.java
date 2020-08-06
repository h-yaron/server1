package com.nice.server1;

import data.MessageType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import service.QueueService;
import web.Listener1;

@SpringBootApplication
@ComponentScan(basePackageClasses = Listener1.class)
@ComponentScan(basePackageClasses = QueueService.class)
@ComponentScan(basePackageClasses = MessageType.class)
public class Listener1Application {

    public static void main(String[] args) {
        SpringApplication.run(Listener1Application.class, args);
    }

}
