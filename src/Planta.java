import java.util.ArrayList;

public class Planta implements Comparable<Planta> {
	
	String tipoPlanta;
	int semana;
	int codigo;
	ArrayList<String> listaplaga =  new ArrayList<>();
	
	int costo;
	int ABONO = 2000;
	int FUMIGACION = 3000;
	
	public Planta(String tipo, int semana, int codigo) {
		this.tipoPlanta = tipo;
		this.semana = semana;
		this.codigo = codigo;
	}
	
	void añadirPlaga (String plaga)
	{
		listaplaga.add(plaga);
	}
	
	int totalCostoPlanta ()
	{
		switch (tipoPlanta) {
		case "cafe":
			ABONO *= 2 ;
			FUMIGACION *= 3;
			costo = 1500 + ABONO + FUMIGACION;
			return costo;
			
		case "frijol":
			FUMIGACION *= 2;
			costo = 2000 + ABONO + FUMIGACION;
			return costo;
			
		default:
			return 0;
		}
	}
	
	int prioridad;
	int prioridad ()
	{
		for (String aux : listaplaga) {
			if (aux == "ninguna") {
				prioridad = -1;
			}
			prioridad = 1;
		}
		return prioridad;
	}
	
	@Override
	public int compareTo(Planta planta) {
		return this.prioridad - planta.prioridad;
	}
	
}
