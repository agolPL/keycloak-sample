package pl.agol.fplparser

import spock.lang.Specification

class FlightPlanParserSpec extends Specification {

    FlightPlanParser flightPlanParser = new FlightPlanParser()

    def "should parse FPL document"() {

        given:
            String flightPlanDocument = "(FPL-LO123-VM\n" +
                    "- TS11/L-VZ/N\n" +
                    "- EPMM1120\n" +
                    "- K420F150 Z/5340N01547E  5347N01543/K0420F100  5238N01831E\n" +
                    "- EPWA120 EPDE\n" +
                    "NAV/ARK  RMK/TSA4  S0090S0700T0040  DOF/011026)"
        when:
            FlightPlan flightPlan = flightPlanParser.parse(flightPlanDocument)

        then:
            with(flightPlan) {
                callsign == "LO123"
                aircraftType == "TS11"
                departure == "EPMM"
                destination == "EPWA"
                route == "- K420F150 Z/5340N01547E  5347N01543/K0420F100  5238N01831E"
            }
    }
}
