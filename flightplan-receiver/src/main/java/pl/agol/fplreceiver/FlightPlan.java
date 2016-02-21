package pl.agol.fplreceiver;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class FlightPlan {

    private String id;
    private String callsign;
    private String aircraftType;
    private String departure;
    private String destination;
    private String route;
    private String pilotName;

    public FlightPlan() {
        id = UUID.randomUUID().toString();
    }
}
