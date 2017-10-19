import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;


public class CrearProductosXML {

	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("productos.dat"));
			Producto pro = null;
			ListaProductos listaProd = new ListaProductos();
			
			try {
				while ((pro = (Producto) ois.readObject()) != null) {
					// añadimos el empleado a la lista
					listaProd.add(pro);
				}
			}catch (EOFException e) {
				System.out.println("Final del fichero");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			XStream xs = new XStream();
			xs.alias("ListaProductos", ListaProductos.class);
			xs.alias("Producto", Producto.class);
			xs.addImplicitCollection(ListaProductos.class, "lista");
			xs.toXML(listaProd, new FileOutputStream("productos.xml"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
