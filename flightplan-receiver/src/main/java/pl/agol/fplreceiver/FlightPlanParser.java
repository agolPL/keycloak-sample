package pl.agol.fplreceiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class FlightPlanParser {

    private final RestTemplate restTemplate;
    private final String flightPlanParserUrl;

    @Autowired
    public FlightPlanParser(RestTemplate restTemplate,
                            @Value("${flightplan-parser-url}") String flightPlanParserUrl) {
        this.restTemplate = restTemplate;
        this.flightPlanParserUrl = flightPlanParserUrl;
    }

    public FlightPlan parse(String flightPlanDocument) {
        return restTemplate.postForObject(getSubmitFlightPlanUri(), flightPlanDocument, FlightPlan.class);
    }

    private URI getSubmitFlightPlanUri() {
        return UriComponentsBuilder
                .fromHttpUrl(flightPlanParserUrl)
                .build()
                .toUri();
    }
}
