package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {

	//http://localhost:8080/JavaAPI/rest/hello/xml
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/xml")
	public Message sayHelloXML() {
		Message message = new Message(1,"Hello", "Eduardo Castillo");
		return message;
	}

	
	//http://localhost:8080/JavaAPI/rest/hello/json
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/json")
	public Message sayHelloJson() {
		Message message = new Message(2,"Hello from Json", "Eduardo Castillo");
		return message;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/jsonParam")
	public Message sayHelloJsonParams(@QueryParam("id") int id, 
			                          @QueryParam("message") String message,
			                          @QueryParam("author") String author) {
		/*
		 * http://localhost:8080/JavaAPI/rest/hello/jsonParam?id=5&message=datosDesdeUrl&author=EduardoCM
		 */
		Message messageParam = new Message(id, message, author);
		return messageParam;
	}
	
	

}
