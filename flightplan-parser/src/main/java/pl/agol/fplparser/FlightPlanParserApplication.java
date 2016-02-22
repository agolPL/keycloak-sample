package pl.agol.fplparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightPlanParserApplication {

    public static void main(String... args) {

        SpringApplication springApplication =
                new SpringApplication(FlightPlanParserApplication.class);
        springApplication.run(args);
    }
}
