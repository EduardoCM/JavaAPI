mport java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlumnoService {
	
	private static Map<Integer, Alumno> alumnos = new HashMap<>(); 
	
	static {
		Alumno eduardo = new Alumno(10221370, "Eduardoo", "Castillo Mendoza", "Ing Informatica");
		Alumno laura = new Alumno(10221740, "Laura", "Mendoza Noguez", "Ing Quimica");
		
		alumnos.put(1, eduardo);
		alumnos.put(2, laura);
	}
	
	
	@GET
	public List<Alumno> getAlumnosJson(){
		return new ArrayList<Alumno>(alumnos.values());
	}
	
	@GET
	@Path("/{alumnoId}")
	public Alumno getAlumno(@PathParam("alumnoId") int id) {
		return alumnos.get(id);
	}
	
	@POST
	public void addAlumno(Alumno alumno) {
		alumnos.put(alumnos.size() + 1, alumno);
	}
	
	@PUT
	@Path("/{alumnoId}")
	public void updateMessage(@PathParam("alumnoId") int id, Alumno alumno) {
		alumnos.put(id, alumno);
	}
	
	
	@DELETE
	@Path("/{alumnoId}")
	public void deleteAlumno(@PathParam("alumnoId") int id) {
		System.out.println(":: Entro a Alumno ::" + id);
		Alumno valor = alumnos.remove(id);
		System.out.println("::: " + valor );
	}
}
