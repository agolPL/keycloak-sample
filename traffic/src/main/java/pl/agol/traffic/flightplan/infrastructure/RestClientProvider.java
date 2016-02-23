package pl.agol.traffic.flightplan.infrastructure;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class RestClientProvider {

    @Inject
    HttpServletRequest httpServletRequest;

    @Produces
    public Client provideRestClient() {
        return ClientBuilder
                .newClient()
                .register(new KeycloakAuthHeadersRequestFilter(httpServletRequest));
    }
}
