package com.prokopenkodi.advise.client.rest.api;

import com.prokopenkodi.advise.client.classes.response.ErrorData;
import com.prokopenkodi.advise.client.classes.response.GetUserResponse;
import com.prokopenkodi.advise.client.pojo.User;

import javax.ws.rs.*;


@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public interface UserProxyAPI {

    @GET
    @Path("{userID}")
    GetUserResponse get(@PathParam("userID") Long userId);


    @GET
    @Path("email/{email}")
    GetUserResponse getByEmail(@PathParam("email") String email);

    @PUT
    ErrorData save(User user);

    @POST
    ErrorData update(User user);

    @DELETE
    @Path("{userID}")
    ErrorData delete(@PathParam("userID") Long userId);
}
