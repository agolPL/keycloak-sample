package pl.agol.traffic.flightplan;

import lombok.Data;

@Data
public class FlightPlan {

    private String id;
    private String callsign;
    private String aircraftType;
    private String departure;
    private String destination;
    private String route;
    private String pilotName;
}
