import java.util.ArrayList;


public class ListaProductos {
	
	private ArrayList<Producto> lista;
	
	

	public ListaProductos() {
		this.lista = new ArrayList<Producto>();
	}

	public ArrayList<Producto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Producto> lista) {
		this.lista = lista;
	}

	public void add(Producto pro) {		
		 lista.add(pro);
	}



}
