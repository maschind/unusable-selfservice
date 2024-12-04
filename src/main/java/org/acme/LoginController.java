package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import io.vertx.ext.web.RoutingContext;

import java.net.URI;

@Path("/login")
public class LoginController {

    @Inject
    Template login;

    @Inject
    RoutingContext routingContext;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getLoginPage() {
        return login.instance();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response processLogin(@FormParam("username") String username,
                                 @FormParam("password") String password) {
        return Response.seeOther(URI.create("/order")).build();
    }
}
