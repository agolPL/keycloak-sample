package pl.agol.briefing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BriefingApplication {

    public static void main(String... args) {
        SpringApplication springApplication =
                new SpringApplication(BriefingApplication.class);
        springApplication.run(args);
    }
}
