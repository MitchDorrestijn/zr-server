package org.han.ica.oose.boterbloem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.han.ica.oose.boterbloem")
@SpringBootApplication
public class SpringBootWithReactJsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithReactJsApplication.class, args);
    }
}
