package com.eloqui;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.eloqui.Main;
import com.eloqui.model.UserProfile;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.internal.MediaTypes;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.util.runner.ConcurrentRunner;

import static org.junit.Assert.assertEquals;

public class UserResourceTest extends JerseyTest {

    private HttpServer server;
    private WebTarget target;
    
    @Override
    protected ResourceConfig configure() {

        return Main.createApp();
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(new JacksonFeature());
    }

    @Before
    public void setUp() throws Exception {
        // start the server
        Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        //server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testRegister() {
        UserProfile user = new UserProfile();
        user.setEmail("xyz@gmail.com");
        user.setFirstName("John");
        user.setLastName("Smith");
        user.setMale(true);
        user.setNickName("John");
        user.setPassword("password1");
        
        Entity<UserProfile> profileEntity = Entity.entity(user, MediaType.APPLICATION_JSON_TYPE);
        
        Response response  = target.path("login/register").request().post(profileEntity);
        assertEquals(response, Response.ok());
    }
    
    //@Test
    public void testLogin() {
        String responseMsg = target.path("define/HelloWorld/user1").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
}
