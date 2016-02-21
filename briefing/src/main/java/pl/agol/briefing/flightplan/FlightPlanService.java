package pl.agol.briefing.flightplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class FlightPlanService {

    private final RestTemplate restTemplate;
    private final String flightPlanReceiverUrl;

    @Autowired
    public FlightPlanService(RestTemplate restTemplate,
                             @Value("${briefing.flightplan-receiver-url}") String flightPlanReceiverUrl) {

        this.restTemplate = restTemplate;
        this.flightPlanReceiverUrl = flightPlanReceiverUrl;
    }

    public FlightPlanValidationResult validate(String flightPlan) {

        //TODO: use validate flight-plan service
        return new FlightPlanValidationResult();
    }

    public void submit(FlightPlanRequest flightPlanRequest) {
        restTemplate.postForLocation(getSubmitFlightPlanUri(), flightPlanRequest);
    }

    private URI getSubmitFlightPlanUri() {
        return UriComponentsBuilder
                .fromHttpUrl(flightPlanReceiverUrl)
                .build()
                .toUri();
    }
}
