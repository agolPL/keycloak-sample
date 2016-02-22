package pl.agol.traffic.flightplan;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class FlightPlanController {

    @Inject
    FlightPlanRestRepository flightPlanRestRepository;

    public List<FlightPlan> getFlightPlans() {
        return flightPlanRestRepository.getFlightPlans();
    }
}
