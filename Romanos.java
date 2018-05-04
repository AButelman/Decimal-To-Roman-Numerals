package convertidorNumerosRomanos;
public class Romanos {
	
	/*
	public static int convertir(String numRom) {
		numRom = numRom.toUpperCase();
		int numero = 0;
		
		int indDer;
		char carDer;
		int valorDer;
		
		int indIzq ;
		char carIzq;
		int valorIzq;
		
		for (int i = numRom.length() - 1; i >= 0; ) {
			valorIzq = 0;
			valorDer = 0;
			
			carDer = numRom.charAt(i);
			valorDer = valorCaracter(carDer);
			
			if (valorDer == -1) {
				return 0;
			}
			
			if ((i - 1) >= 0) {
				indIzq = i - 1;
				carIzq = numRom.charAt(indIzq);
				valorIzq = valorCaracter(carIzq);
			} else {
				valorIzq = 0;
			}
			
			if (valorIzq >= valorDer) {
				if ((valorIzq == 1 && valorDer == 1) || (valorIzq == 5 && valorDer == 1) ||
						(valorIzq == 10 && valorDer == 1) || (valorIzq == 10 && valorDer == 10) ||
						(valorIzq == 50 && valorDer == 1) || (valorIzq == 50 && valorDer == 5) || 
						(valorIzq == 50 && valorDer == 10) || (valorIzq == 100 && valorDer == 1) ||
						(valorIzq == 100 && valorDer == 5) || (valorIzq == 100 && valorDer == 10) ||
						(valorIzq == 100 & valorDer == 100) ||
						(valorIzq == 500 && valorDer == 1) || (valorIzq == 500 && valorDer == 5) ||
						(valorIzq == 500 && valorDer == 10) || (valorIzq == 500 && valorDer == 50) ||
						(valorIzq == 500 && valorDer == 100) || (valorIzq == 1000 && valorDer == 1) ||
						(valorIzq == 1000 && valorDer == 5) || (valorIzq == 1000 && valorDer == 10) ||
						(valorIzq == 1000 && valorDer == 50) || (valorIzq == 1000 && valorDer == 100) ||
						(valorIzq == 1000 && valorDer == 1000)) {
				
					numero += valorIzq + valorDer;
					i -= 2;
				} else {
					return 0;
				}
				
			} else {
				if ((valorDer == 5 && valorIzq == 1) || (valorDer == 10 && valorIzq == 1) ||
						(valorDer == 50 && valorIzq == 10) || (valorDer == 100 && valorIzq == 10) ||
						(valorDer == 500 && valorIzq == 100) || (valorDer == 1000 && valorIzq == 100)) {
					numero += valorDer - valorIzq;
					
					i -= 2;
				} else if ((valorIzq == 1 && valorDer == 1) || (valorIzq == 5 && valorDer == 1) ||
						(valorIzq == 10 && valorDer == 1) || (valorIzq == 10 && valorDer == 10) ||
						(valorIzq == 50 && valorDer == 1) || (valorIzq == 50 && valorDer == 5) || 
						(valorIzq == 50 && valorDer == 10) || (valorIzq == 100 && valorDer == 1) ||
						(valorIzq == 100 && valorDer == 5) || (valorIzq == 100 && valorDer == 10) ||
						(valorIzq == 100 & valorDer == 100) ||
						(valorIzq == 500 && valorDer == 1) || (valorIzq == 500 && valorDer == 5) ||
						(valorIzq == 500 && valorDer == 10) || (valorIzq == 500 && valorDer == 50) ||
						(valorIzq == 500 && valorDer == 100) || (valorIzq == 1000 && valorDer == 1) ||
						(valorIzq == 1000 && valorDer == 5) || (valorIzq == 1000 && valorDer == 10) ||
						(valorIzq == 1000 && valorDer == 50) || (valorIzq == 1000 && valorDer == 100) ||
						(valorIzq == 1000 && valorDer == 1000) || (valorIzq == 0)){
					numero += valorDer;
					i--;
				} else {
					return 0;
				}
			}
			
		}
		
		return numero;
	} */
	/*
	private static int valorCaracter(char caracter) {
		int valor = 0;
		String car = String.valueOf(caracter);
		
		switch (car) {
			case "M": 
				valor = 1000;
				break;
			case "D":
				valor = 500;
				break;
			case "C":
				valor = 100;
				break;
			case "L":
				valor = 50;
				break;
			case "X":
				valor = 10;
				break;
			case "V":
				valor = 5;
				break;
			case "I":
				valor = 1;
				break;
			default:
				valor = -1;
				break;
		}
		
		return valor;
	} */

	public static String convertir(int num) {
		String numRom;
		
		if(validarNumero(num)) {
			numRom = convertirARomano(num);
		} else {
			numRom = "";
		}
		
		return numRom;
	}
	
	private static String convertirARomano(int num) {
		String numRom = "";
		String unidades = "", decenas = "", centenas = "", milenas = "";
		
		unidades = digitos(valorCaracter(num, 1), 0);
		
		if (num > 9) {
			decenas = digitos(valorCaracter(num, 2), 1);
		}
		
		if (num > 99) {
			centenas = digitos(valorCaracter(num, 3), 2);
		}
		
		if (num > 999 && num < 4000) {
			milenas = hastaTresVeces("M", valorCaracter(num, 4));
		}
		
		numRom = milenas + centenas + decenas + unidades;
		
		return numRom;
	}

	private static int valorCaracter(int num, int numCaracter) {
		String cadena = Integer.toString(num);
		int valor = 0;
		String caracter;
		
		caracter = String.valueOf(cadena.charAt(cadena.length() - numCaracter));
		valor = Integer.valueOf(caracter);
		
		return valor;
	}
	
	private static String digitos(int num, int digito) {
		String numRom = "", max = "", med = "", min = "";
		
		switch (digito) {
			case 0:
				max = "X";
				med = "V";
				min = "I";
				break;
			case 1:
				max = "C";
				med = "L";
				min = "X";
				break;
			case 2:
				max = "M";
				med = "D";
				min = "C";
				break;
		}
		
		if (num > 0) {
			if (num <= 3) {
				numRom = hastaTresVeces(min, num);
			} else if (num == 4) {
				numRom = min + med;
			} else if (num == 5) {
				numRom = med;
			} else if (num <= 8) {
				numRom = med + hastaTresVeces(min, num - 5);
			} else if (num == 9) {
				numRom = min + max;
			}
		}
		
		return numRom;
	}
	
	private static String hastaTresVeces(String simbolo, int veces) {
		String numRom = "";
		
		if (veces <= 3) {
			for (int i = 1; i <= veces; i++) {
				numRom += simbolo;
			}
		}
		
		return numRom;
	}
	
	private static boolean validarNumero(int num) {
		boolean valido;
		
		if (num > 0 && num < 4000) valido = true; else valido = false;
		
		return valido;
	}
}
