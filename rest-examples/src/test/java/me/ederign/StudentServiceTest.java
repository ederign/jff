package me.ederign;

import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        
       
//         c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testStudentByLogin() {
        Student responseMsg = 
        		getUsuario();
        assertNotNull(responseMsg);
    }

	private Student getUsuario() {
		return target.path("student/eder").request().get(Student.class);
	}
    
    @Test
    public void testStudentById() {
        Student responseMsg = target.path("student/123").request().get(Student.class);
        assertNotNull(responseMsg);
    }
//    @Test
//    public void testStudentsByZip() {
//        Students responseMsg = target.path("student?zip=123").request().get(Students.class);
//        assertNotNull(responseMsg);
//    }
//    @Test
//    public void testStudentsByName() {
//        Students responseMsg = target.path("student/search?firstName=Eder;lastName=Ignatowicz").request().get(Students.class);
//        assertNotNull(responseMsg);
//    }
}
