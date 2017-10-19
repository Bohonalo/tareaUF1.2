import java.util.ArrayList;

public class ListaAsignaturas {
	
	private ArrayList<Asignatura> lista;
	
	
	
	
	public ListaAsignaturas() {

	}


	public ArrayList<Asignatura> getLista() {
		return lista;
	}


	public void setLista(ArrayList<Asignatura> lista) {
		this.lista = lista;
	}

	public void add(Asignatura asig) {		
		 lista.add(asig);
	}

}
