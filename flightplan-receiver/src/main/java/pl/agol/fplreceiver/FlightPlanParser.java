package pl.agol.fplreceiver;

import org.springframework.stereotype.Component;

@Component
public class FlightPlanParser {

    public FlightPlan parse(String flightPlan) {
        return new FlightPlan();
    }
}
