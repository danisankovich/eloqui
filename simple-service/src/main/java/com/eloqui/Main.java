package com.eloqui;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;


import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
    static final URI BASE_URI = URI.create("http://localhost:8080/eloqui/");

    @SuppressWarnings({"ResultOfMethodCallIgnored"})
    public static void startServer() {
        try {
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createApp());

            System.out.println(String.format("Application started.%nHit enter to stop it..."));
            System.in.read();
            server.shutdownNow();
        } catch (IOException ex) {
        }

    }
    
    public static class MyApplication extends ResourceConfig {
        public MyApplication() {
            super(
                    UserResource.class,
                    SuggestResource.class,
                    JacksonFeature.class
            );
        }
    }

    public static ResourceConfig createApp() {
        return new MyApplication();
    }
         
}

