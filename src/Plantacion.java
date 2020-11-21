import java.util.*;

public class Plantacion 
{
	PriorityQueue<Planta> colaPlanta = new PriorityQueue<>();
	
	void añadirPlanta (Planta planta)
	{
		colaPlanta.add(planta);
	}
	
	void mostrarDatosPlantacion ()
	{
		for (Planta planta : colaPlanta) {
			System.out.println("Tipo de planta: " + planta.tipoPlanta + "\nCodigo: " + planta.codigo 
					+ "\nCosto de la planta: " + planta.totalCostoPlanta() + "\n");
		}
	}
	
	void mostrarCantidadPlantas ()
	{
		Hashtable<String, Integer> hashtable = new Hashtable<>();
		for (Planta planta : colaPlanta) {
			int cont = 1;
			if (hashtable.containsKey(planta.tipoPlanta)) {
				cont =  hashtable.get(planta.tipoPlanta);
				cont++;
			}
			hashtable.put(planta.tipoPlanta, cont);
		}
		
		hashtable.forEach((key, value) -> {
			System.out.println(key + ": " + value);
		});
	}
	
	void totalInversionxPlanta ()
	{
		int totalInvertido = 0;
		Hashtable<String, Integer> hashtable = new Hashtable<>();
		for (Planta planta : colaPlanta) {
			int total = planta.costo;
			if (hashtable.containsKey(planta.tipoPlanta)) {
				total = hashtable.get(planta.tipoPlanta);
				total += planta.costo; 
				totalInvertido += total;
			}
			hashtable.put(planta.tipoPlanta, total);
		}
		
		hashtable.forEach((key, value) -> {
			System.out.println("Total invertido en " + key + ": " + value);
		});
		System.out.println("Total invertido: " + totalInvertido);
	}
	
	void totalInversionxSemana () 
	{
		int totalInvertido = 0;
		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		for (Planta planta : colaPlanta) {
			int total = planta.costo;
			if (hashtable.containsKey(planta.semana)) {
				total = hashtable.get(planta.semana);
				total += planta.costo; 
				totalInvertido += total;
			}
			hashtable.put(planta.semana, total);
		}
		
		hashtable.forEach((key, value) -> {
			System.out.println("Total invertido en la semana " + key + ": " + value);
		});
		System.out.println("Total invertido: " + totalInvertido);
	}
	
	void buscador (int codigo)
	{
		for (Planta planta : colaPlanta) {
			if (planta.codigo == codigo) {
				System.out.println("Tipo de planta: " + planta.tipoPlanta + "\nCodigo: " + planta.codigo 
						+ "\nCosto de la planta: " + planta.totalCostoPlanta() + "\nPlagas encontradas: ");
				System.out.println(planta.listaplaga);
			}
		}
	}
}
