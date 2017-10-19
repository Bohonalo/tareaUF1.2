import java.io.*;

public class InsertarAsignaturasBinObj {

	public static void main(String[] args) {
		
		String[] asignaturas = {"Prog", "BBDD", "ED", "SI", "LM"};
		String[] profesores = {"Alberto", "Guillermo", "Alejandro", "Ana", "Patricia"};
		int[] numHoras = {8, 6, 3, 6, 4};
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("asignaturas.dat"));
			
			for (int i = 0; i < numHoras.length; i++) {
				oos.writeObject(new Asignatura(i+1, asignaturas[i], profesores[i], numHoras[i]));
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}


	}

}