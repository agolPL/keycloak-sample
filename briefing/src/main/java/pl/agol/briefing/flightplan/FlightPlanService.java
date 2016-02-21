package pl.agol.briefing.flightplan;

import org.springframework.stereotype.Service;

@Service
public class FlightPlanService {

    public FlightPlanValidationResult validate(String flightPlan) {

        //TODO: use validate flight-plan service
        return new FlightPlanValidationResult();
    }

    public void submit(FlightPlanRequest flightPlanRequest) {

    }
}
