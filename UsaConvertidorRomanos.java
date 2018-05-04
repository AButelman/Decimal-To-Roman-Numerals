package convertidorNumerosRomanos;
import java.util.Scanner;

public class UsaConvertidorRomanos {

	private static Scanner lector = new Scanner(System.in);
	
	public static void main(String[] args) {
		int numero;
		
		System.out.print("Ingrese el número natural a convertir (1 - 3999) o 0 para terminar: ");
		numero = lector.nextInt();
		
		while (numero != 0) {
			
			if (numero > 0 && numero < 4000) {
				System.out.println("\nSu representacion en números romanos es " 
										+ Romanos.convertir(numero));
			} else {
				System.out.println("\nNúmero fuera de rango.");
			}
			
			lector.nextLine();
			
			System.out.print("\nIngrese el número natural a convertir (1 - 3999) o 0 para terminar: ");
			numero = lector.nextInt();
		}
		
		lector.close();
	}
}
