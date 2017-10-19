import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.thoughtworks.xstream.XStream;

public class CrearAsignaturasXML {

	public static void main(String[] args) {
ObjectInputStream ois = null;
		
		
	
			try {
				ois = new ObjectInputStream(new FileInputStream("asignaturas.dat"));
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				DOMImplementation implementacion = db.getDOMImplementation();
				
				Document doc = implementacion.createDocument(null, "Asignatura", null);
				doc.setXmlVersion("1.0");
				
				Asignatura asig = null;
				Element elemento = null;
				
				try {
					while ((asig = (Asignatura) ois.readObject())!= null) {
						System.out.println ("Id: " + asig.getId() + 
								"Nombre: " + asig.getNombre() +
								"Profesor" + asig.getProfesor() +
								"Horas" + asig.getHoras());
						
						elemento = doc.createElement("empleado");   
						doc.getDocumentElement().appendChild(elemento);
						
						crarElementoHijo(doc, elemento, "Id", asig.getId()+"");
						crarElementoHijo(doc, elemento, "Nombe", asig.getNombre());
						crarElementoHijo(doc, elemento, "Profesor", asig.getProfesor());
						crarElementoHijo(doc, elemento, "Horas", asig.getHoras()+"");						
					}
				}catch (EOFException e) {
					System.out.println("Fin del fichero.");
				} 
				
				Source source = new DOMSource(doc);
				// Creamos el resultado en el fichero empleados.xml
				Result result = new StreamResult(new File("asignaturas.xml"));
				
				// Obtenemos un TransformerFactory
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				// Le damos formato y realizamos la transformación del documento a fichero
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty(OutputKeys.METHOD, "xml"); 
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				transformer.transform(source,  result); 
				
				// Mostramos el documento por pantalla especificando como canal de salida
				// el System.out
				Result console = new StreamResult(System.out);
				transformer.transform(source, console);
				
				//leemos con XStream
				
				FileInputStream fis = null;
				
				XStream xs = new XStream();
				xs.alias("Asignaturas", ListaAsignaturas.class);
				xs.alias("DatosAsignaturas", Asignatura.class);
				xs.addImplicitCollection(ListaAsignaturas.class, "lista");
				
				fis = new FileInputStream("Asignaturas.xml");
				
				ListaAsignaturas listaTotal = (ListaAsignaturas) xs.fromXML(fis);
				
				ArrayList<Asignatura> listaAsig = new ArrayList<Asignatura>();
				listaAsig = listaTotal.getLista();
				
				for (Asignatura emp : listaAsig) {
					System.out.println("ID: " + emp.getId()
										+ "Nombre" + emp.getNombre()
										+ "Profesor" + emp.getProfesor()
										+ "Horas" + emp.getHoras());
					
				}
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			} finally {
				if (ois != null){
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

	}
	private static void crarElementoHijo(Document doc,  Element elemento, String nomElemento,
			String valor) {
		Element elemHijo = doc.createElement(nomElemento);
		Text text = doc.createTextNode(valor);
		elemento.appendChild(elemHijo);
		elemHijo.appendChild(text);
	}

}
