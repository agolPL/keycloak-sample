package pl.agol.traffic.flightplan.infrastructure;

import org.keycloak.KeycloakPrincipal;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

public class KeycloakAuthHeadersRequestFilter implements ClientRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_TYPE = "Bearer ";

    private final HttpServletRequest httpServletRequest;

    public KeycloakAuthHeadersRequestFilter(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext
                .getHeaders()
                .add(AUTHORIZATION_HEADER, TOKEN_TYPE + getTokenString());
    }

    private String getTokenString() {
        KeycloakPrincipal keycloakPrincipal =
                (KeycloakPrincipal) httpServletRequest.getUserPrincipal();

        return keycloakPrincipal
                .getKeycloakSecurityContext()
                .getTokenString();
    }
}
