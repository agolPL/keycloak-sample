package pl.agol.fplparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class FlightPlanParserController {

    private final FlightPlanParser flightPlanParser;

    @Autowired
    public FlightPlanParserController(FlightPlanParser flightPlanParser) {
        this.flightPlanParser = flightPlanParser;
    }

    @RequestMapping(value = "/api/flightplan/parse", method = POST)
    public FlightPlan parse(@RequestBody String flightPlanDocument) {
        return flightPlanParser.parse(flightPlanDocument);
    }
}
