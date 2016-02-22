package pl.agol.fplparser;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FlightPlanParser {

    public FlightPlan parse(String flightPlan) {
        String[] flightPlanLines = flightPlan.split("\\n");
        return new FlightPlan()
                .setCallsign(getCallsign(flightPlanLines[0]))
                .setAircraftType(getAircraftType(flightPlanLines[1]))
                .setDeparture(getAirport(flightPlanLines[2]))
                .setDestination(getAirport(flightPlanLines[4]))
                .setRoute(flightPlanLines[3]);
    }

    private String getCallsign(String flightPlanPart) {
        return cutFplElementByRegex("-[A-Z0-9]{3,}", flightPlanPart);
    }

    private String cutFplElementByRegex(String regexp, String flightPlanPart) {
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(flightPlanPart);
        if (matcher.find()) {
            return clearFplElement(matcher.group(0));
        }
        return null;
    }

    private String clearFplElement(String flightPlanElement) {
        return flightPlanElement
                .replace("-", "")
                .replace(" ", "");
    }

    private String getAircraftType(String flightPlanPart) {
        return cutFplElementByRegex("- [A-Z0-9]{3,}", flightPlanPart);
    }

    private String getAirport(String flightPlanPart) {
        return cutFplElementByRegex("- [A-Z]{4}", flightPlanPart);
    }
}
