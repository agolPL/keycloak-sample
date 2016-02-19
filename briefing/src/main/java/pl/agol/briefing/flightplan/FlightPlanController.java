package pl.agol.briefing.flightplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/flightplan")
public class FlightPlanController {

    private final FlightPlanService flightPlanService;

    @Autowired
    public FlightPlanController(FlightPlanService flightPlanService) {
        this.flightPlanService = flightPlanService;
    }

    @RequestMapping(method = GET)
    public String flightPlanForm() {
        return "flight-plan";
    }


    @RequestMapping(method = POST)
    public String submitFlightPlanForm(FlightPlanSubmitRequest flightPlanSubmitRequest) {
        return "success";
    }
}
