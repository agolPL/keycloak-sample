package pl.agol.traffic.flightplan;

import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class RestClientProvider {

    @Produces
    public Client provideRestClient() {
        return ClientBuilder.newClient();
    }
}
