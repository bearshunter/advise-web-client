package com.prokopenkodi.advise.client.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class HttpClient {

    public String getRequester(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("advisenet-1.0/user/ping");
        return target.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON).get(String.class);
    }


}
