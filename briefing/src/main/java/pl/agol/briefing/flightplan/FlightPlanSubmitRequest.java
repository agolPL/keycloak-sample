package pl.agol.briefing.flightplan;

import lombok.Data;

@Data
public class FlightPlanSubmitRequest {

    private String flightPlan;
    private String pilotNickname;
}
