package com.eloqui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.eloqui.engine.SuggestionEngine;
import com.eloqui.model.Request;

/**
 * Suggest resource 
 */
@Path("suggest")
public class SuggestResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("log/{user}/{word}")
    public Response logRequest(@PathParam("user")String user, @PathParam("word") String word) {
        Request request = new Request();
        request.setUserId(user);
        request.setWord(word);
        engine.logRequest(request);
        return Response.ok().build();
    }
    
    @GET
    @Path("{user}/{words}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getWordDefinition(@PathParam("words") String word, @PathParam("user") String userId) {
        
        System.out.println("Retrieving suggections for " + userId + " " + word);
        String response = "";
        for(String possibility : engine.getSuggestions(userId, Arrays.asList(word.split("_"))))
        {
            response += possibility + ":";
        }
        
        return Response.ok(response).build() ;
    }
    
    static SuggestionEngine engine = new SuggestionEngine(); 
    
}
