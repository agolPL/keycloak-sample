package pl.agol.traffic.flightplan;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.Arrays.asList;

@Named
public class FlightPlanRestRepository {

    private static final String FPL_RECEIVER_URL = "http://localhost:8090/api/flightplans/";

    @Inject
    Client restClient;

    public List<FlightPlan> getFlightPlans() {

        return asList(restClient
                .target(FPL_RECEIVER_URL)
                .request(MediaType.APPLICATION_JSON)
                .get(FlightPlan[].class));
    }
}
