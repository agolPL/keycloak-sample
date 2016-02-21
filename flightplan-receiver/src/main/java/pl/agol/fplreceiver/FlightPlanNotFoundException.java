package pl.agol.fplreceiver;

public class FlightPlanNotFoundException extends RuntimeException {

    public FlightPlanNotFoundException(String id) {
        super("Could not found flight plan: " + id);
    }
}
