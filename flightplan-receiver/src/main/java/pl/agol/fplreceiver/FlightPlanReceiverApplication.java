package pl.agol.fplreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightPlanReceiverApplication {

    public static void main(String... args) {

        SpringApplication flightPlanReceiverApplication =
                new SpringApplication(FlightPlanReceiverApplication.class);
        flightPlanReceiverApplication.run(args);
    }
}
