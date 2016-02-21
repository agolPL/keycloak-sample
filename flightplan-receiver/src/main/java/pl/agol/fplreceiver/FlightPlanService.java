package pl.agol.fplreceiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FlightPlanService {

    private final FlightPlanParser flightPlanParser;
    private final FlightPlanRepository flightPlanRepository;

    @Autowired
    public FlightPlanService(FlightPlanParser flightPlanParser, FlightPlanRepository flightPlanRepository) {
        this.flightPlanParser = flightPlanParser;
        this.flightPlanRepository = flightPlanRepository;
    }

    public FlightPlan receive(String flightPlanText, String pilotName) {
        log.info("Received flight plan: " + flightPlanText);
        FlightPlan flightPlan = flightPlanParser
                .parse(flightPlanText)
                .setPilotName(pilotName);
        flightPlanRepository.save(flightPlan);
        return flightPlan;
    }

    public List<FlightPlan> getAll() {
        return flightPlanRepository.findAll();
    }

    public FlightPlan findOne(String id) {
        Optional<FlightPlan> flightPlan = flightPlanRepository.findOne(id);
        if (flightPlan.isPresent()) {
            return flightPlan.get();
        }
        throw new FlightPlanNotFoundException(id);
    }
}
