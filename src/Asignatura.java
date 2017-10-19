import java.io.Serializable;

public class Asignatura implements Serializable{
	
	private static final long serialVersionUID = -520862480524757418L;
	
	private int id;
	private String nombre;
	private String profesor;
	private int horas;
	
	public Asignatura(int id, String nombre, String profesor, int horas) {
		this.id = id;
		this.nombre = nombre;
		this.profesor = profesor;
		this.horas = horas;
	}

	public Asignatura() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

}
