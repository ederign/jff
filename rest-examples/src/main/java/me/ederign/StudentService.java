package me.ederign;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/student")
@Produces(MediaType.APPLICATION_XML)
// @Produces(MediaType.APPLICATION_JSON)
public class StudentService {

	@GET
	@Path("{login: [a-z]*}")
	public Response getStudentByLogin(@PathParam("login") String login) {
		Student student = new Student("Eder", "Ignatowicz", "bla@gmail.com",
				"1234565");
		student.setLogin(login);
		return Response.ok(student).build();
	}

	@GET
	@Path("{studentId : \\d+}")
	public Response getCustomerById(@PathParam("studentId") Long id) {
		Student student = new Student("Eder", "Ignatowicz", "bla@gmail.com",
				"1234565");
		student.setId(id);
		return Response.ok(student).build();
	}

	@GET
	public Response getStudentByZipCode(@QueryParam("zip") Long zip) {
		Students students = new Students();
		students.add(new Student("Eder", "Ignatowicz", "bla@gmail.com",
				"1234565"));
		students.add(new Student("Eder Outro", "Ignatowicz", "bla@gmail.com",
				"1234565"));
		return Response.ok(students).build();
	}


	@GET
	@Path("search")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getStudentsByName(
			@MatrixParam("firstName") String firstName,
			@MatrixParam("lastName") String lastName) {
		Students students = new Students();
		students.add(new Student("Eder", "Ignatowicz", "bla@gmail.com",
				"1234565"));
		students.add(new Student("Eder Outro", "Ignatowicz", "bla@gmail.com",
				"1234565"));
		return Response.ok(students).build();
	}
}
