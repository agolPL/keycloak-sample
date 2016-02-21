package pl.agol.fplreceiver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.unmodifiableList;

@Repository
public class FlightPlanRepository {

    private final List<FlightPlan> flightPlans = new ArrayList<>();

    public void save(FlightPlan flightPlan) {
        flightPlans.add(flightPlan);
    }

    public List<FlightPlan> findAll() {
        return unmodifiableList(flightPlans);
    }

    public Optional<FlightPlan> findOne(String id) {
        return flightPlans.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();
    }
}
