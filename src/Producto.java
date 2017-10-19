import java.io.Serializable;

public class Producto implements Serializable{
	
	private static final long serialVersionUID = 3686104072694690329L;
	
	int id;
	String nombre;
	String medidas;
	float precio;
	
	
	
	public Producto(int id, String nombre, String medidas, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.medidas = medidas;
		this.precio = precio;
	}
	
	
	public Producto() {
		super();
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
	public String getMedidas() {
		return medidas;
	}
	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

}
