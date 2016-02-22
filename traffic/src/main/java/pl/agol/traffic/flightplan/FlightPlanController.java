package pl.agol.traffic.flightplan;

import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named
public class FlightPlanController {

    public List<FlightPlan> getFlightPlans() {
        return Arrays.asList(
                new FlightPlan()
                        .setAircraftType("B737"),
                new FlightPlan()
                        .setAircraftType("AC10")
        );
    }
}
