package pl.coderslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"pl.coderslab"})
@EnableJpaRepositories("pl.coderslab.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}