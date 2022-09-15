import java.util.Random;

//final para não ser possível herança, sem utilidade herdar desta classe.
public final class Dado {
	
	//classe geradora de numeros pseudoaleatórios
	static Random dado = new Random();
	
	//consutor default
	public Dado() {
		//default
	}
	
	//metodo estático para rolar um dado padrão (D6)
	public static int rolar() {
		return dado.nextInt(6)+1;
	}
	
	//metodo para rolar um dado de n lados (D4, D8, D10, D20, ...)
	public static int rolar(int lados) {
		return dado.nextInt(lados)+1;
	}
	
}