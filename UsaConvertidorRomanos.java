package convertidorNumerosRomanos;
import java.util.Scanner;

public class UsaConvertidorRomanos {

	private static Scanner lector = new Scanner(System.in);
	
	public static void main(String[] args) {
		int numero;
		
		System.out.print("Ingrese el n�mero natural a convertir (1 - 3999) o 0 para terminar: ");
		numero = lector.nextInt();
		
		while (numero != 0) {
			
			if (numero > 0 && numero < 4000) {
				System.out.println("\nSu representacion en n�meros romanos es " 
										+ Romanos.convertir(numero));
			} else {
				System.out.println("\nN�mero fuera de rango.");
			}
			
			lector.nextLine();
			
			System.out.print("\nIngrese el n�mero natural a convertir (1 - 3999) o 0 para terminar: ");
			numero = lector.nextInt();
		}
		
		lector.close();
	}
}
