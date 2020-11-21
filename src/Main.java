import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Plantacion pla = new Plantacion();
		
		BufferedReader bf = new BufferedReader(new FileReader("Datos-Plantacion.txt"));
		int cantidadPlantas = Integer.parseInt(bf.readLine());
		
		String[] arrPlantas;
		for (int i = 0; i < cantidadPlantas; i++)
		{
			arrPlantas = bf.readLine().split(", ");
			Planta planta = new Planta(arrPlantas[0], Integer.parseInt(arrPlantas[1]), Integer.parseInt(arrPlantas[2]));
			
			int cantPlaga = Integer.parseInt(arrPlantas[3]);
			for (int j = 0; j < cantPlaga; j++) {
				String plaga = bf.readLine();
				planta.añadirPlaga(plaga);
			}
			
			pla.añadirPlanta(planta);
		}
		
		/* 1. Muestra los datos del sistema
		 * 2. Calcular inversion
		 * 3. Priorisar las plantas enfermas
		 */
		
		System.out.println("--- DATOS DEL SISTEMA ---");
		System.out.println("--- Inventario ---");
		pla.mostrarCantidadPlantas();
		System.out.println("--- Planta especifica ---");
		pla.buscador(2);
		
		System.out.println("--- Orden de tratamiento ---");
		pla.mostrarDatosPlantacion();
		
		System.out.println("--- DATOS DE INVERSION ---");
		System.out.println("--- Invertido por tipo de planta ---");
		pla.totalInversionxPlanta();
		System.out.println("--- Invertido por semana ---");
		pla.totalInversionxSemana();
		
		
	}

}
