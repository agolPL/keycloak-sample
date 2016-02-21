package pl.agol.fplreceiver;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class FlightPlanRequest {

    @NotEmpty
    private String flightPlan;

    @NotEmpty
    private String pilotName;
}
