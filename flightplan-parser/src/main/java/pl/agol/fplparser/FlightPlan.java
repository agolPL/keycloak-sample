package pl.agol.fplparser;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FlightPlan {

    private String callsign;
    private String aircraftType;
    private String departure;
    private String destination;
    private String route;
}
