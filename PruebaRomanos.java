package convertidorNumerosRomanos;

public class PruebaRomanos {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 3999; i++) {
			System.out.println(i + ": " + Romanos.convertir(i));
		}

	}

}
