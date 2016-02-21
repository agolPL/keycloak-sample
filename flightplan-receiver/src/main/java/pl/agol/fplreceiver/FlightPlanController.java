package pl.agol.fplreceiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/flightplans")
public class FlightPlanController {

    private final FlightPlanService flightPlanService;

    @Autowired
    public FlightPlanController(FlightPlanService flightPlanService) {
        this.flightPlanService = flightPlanService;
    }


    @RequestMapping(method = POST)
    public ResponseEntity receive(@RequestBody FlightPlanRequest flightPlanRequest) {

        FlightPlan flightPlan = flightPlanService.receive(
                flightPlanRequest.getFlightPlan(), flightPlanRequest.getPilotName());

        return ResponseEntity
                .created(buildUriFor(flightPlan))
                .build();
    }

    private URI buildUriFor(FlightPlan flightPlan) {
        return UriComponentsBuilder
                .fromPath("/api/flightplans/{id}")
                .buildAndExpand(flightPlan.getId())
                .toUri();
    }

    @RequestMapping(method = GET)
    public List<FlightPlan> getAll() {
        return flightPlanService.getAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public FlightPlan find(@PathVariable("id") String id) {
        return flightPlanService.findOne(id);
    }

    @ExceptionHandler(FlightPlanNotFoundException.class)
    public ResponseEntity flightPlanNotFoundHandler() {
        return ResponseEntity
                .notFound()
                .build();
    }
}
