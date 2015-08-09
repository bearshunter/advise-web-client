package com.prokopenkodi.advise.client.rest.client;

import com.prokopenkodi.advise.client.rest.api.UserProxyAPI;
import lombok.Getter;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Scope("singleton")
public class AdviserHttpClient {

    @Autowired
    private Environment environment;

    @Getter
    private UserProxyAPI userProxyAPI;

    @PostConstruct
    private void init(){
        userProxyAPI  = buildUserProxy();
    }

    private UserProxyAPI buildUserProxy(){
        String serverContext = environment.getProperty("server.context");
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(serverContext);
        return target.proxy(UserProxyAPI.class);
    }

}
