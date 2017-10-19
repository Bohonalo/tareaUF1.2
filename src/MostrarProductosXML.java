import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MostrarProductosXML {

	public static void main(String[] args) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document document = db.parse(new File("productos.xml"));
			
			Node raiz = document.getFirstChild();
			System.out.println(raiz.getNodeName());
			NodeList elementos = raiz.getChildNodes();
			
			obtenerNodosHijos(elementos, "");
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	private static void obtenerNodosHijos(NodeList elementos, String tab) {
		 
		 Node nodo;
		 NodeList hijos;
		 NamedNodeMap attrs;
		 Attr attribute;
		 if (elementos.getLength() > 1) {
			 for (int i = 0; i < elementos.getLength(); i++) {
					// accedemos a los elementos de la lista --> empleado
					nodo = elementos.item(i);
					
					// para cada nodo comprobamos que sea de tipo elemento
					if (nodo.getNodeType() == Node.ELEMENT_NODE) {
						// sacamos por consola el nombre de la etiqueta tabulandola con
						// respecto a nodo raíz
						System.out.print( tab +"\t" + nodo.getNodeName());
						
						if (nodo.hasAttributes()) {
							attrs = nodo.getAttributes();
							for (int j = 0; j < attrs.getLength(); j++) {
								attribute = (Attr)attrs.item(j);
								System.out.print("\t" + attribute);
								
							}
							
						}
						System.out.println("");
						// accedemos a la lista de leementos hijos del nodo que estamos trabajando
						hijos = nodo.getChildNodes();
						obtenerNodosHijos(hijos, tab +"\t");
					}
			 }
		 }else {
			 System.out.println( tab + "\t" + elementos.item(0).getNodeValue());
		 	}
	 }

}
