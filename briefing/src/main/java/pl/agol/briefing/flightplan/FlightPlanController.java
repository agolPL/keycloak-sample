package pl.agol.briefing.flightplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/flightplan")
public class FlightPlanController extends WebMvcConfigurerAdapter {

    private final FlightPlanService flightPlanService;

    @Autowired
    public FlightPlanController(FlightPlanService flightPlanService) {
        this.flightPlanService = flightPlanService;
    }

    @RequestMapping(method = GET)
    public String flightPlanForm(FlightPlanRequest flightPlanRequest) {
        return "flight-plan";
    }


    @RequestMapping(method = POST)
    public String submitFlightPlanForm(@Valid FlightPlanRequest flightPlanRequest,
                                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "flight-plan";
        }
        return "success";
    }
}
