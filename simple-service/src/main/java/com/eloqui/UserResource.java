package com.eloqui;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.eloqui.engine.RegistrationEngine;
import com.eloqui.model.UserLogin;
import com.eloqui.model.UserProfile;

/**
 * Suggest resource 
 */
@Path("login")
public class UserResource {

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("register/{email}/{pass}")
    public Response register(@PathParam("email") String email, @PathParam("pass") String password) {
        UserProfile newUser = new UserProfile();
        newUser.setEmail(email);
        newUser.setPassword(password);
        
        if(!registrationEngine.userExists(newUser))
        {
            registrationEngine.register(newUser);
            return Response.ok().build();
        }
        return Response.status(Status.CONFLICT).build();
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{email}/{pass}")
    public Response login(@PathParam("email") String email, @PathParam("pass") String password){
        UserLogin loginInfo = new UserLogin();
        loginInfo.setEmail(email);
        loginInfo.setPassword(password);
        UserProfile userProfile = registrationEngine.getUserProfile(loginInfo);
        if(userProfile == null)
        {
            return Response.status(Status.NOT_FOUND).build();
        }
        else if(userProfile.getPassword().equals(loginInfo.getPassword()))
        {
            return Response.ok().build();
        }
        return Response.status(Status.UNAUTHORIZED).build();
    }
    
    
    
    static RegistrationEngine registrationEngine = new RegistrationEngine();
    
}
