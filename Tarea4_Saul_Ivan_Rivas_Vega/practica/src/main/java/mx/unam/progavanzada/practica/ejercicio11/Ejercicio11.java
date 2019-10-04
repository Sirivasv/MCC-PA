package mx.unam.progavanzada.practica.ejercicio11;

import mx.unam.progavanzada.practica.Util;

/**
 * Clase que determina si una frase es palindromo
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Sep 26, 2019, 8:14:35 PM
 *
 */
public class Ejercicio11 {
	/**
	 * Si el caracter corresponde a una letra (a-z), devuelve true,
	 * false en caso contrario
	 * @param letra
	 * @return
	 */
	private boolean esCaracter(char letra) {
		return Character.isLetter(letra);
	}
	
	/**
	 * Función que determina si una palabra es palindromo. La evaluación 
	 * considera que se tienen dos "punteros" distintos. Uno que apunta a 
	 * la posición inicial del primer caracter de la cadena o "lado izquierdo" 
	 * (pIzq) y el otro, apunta al final de la cadena o al "lado derecho" (pDer).
	 * 
	 * pIzq avanzará de 0 en adelante hasta que no se encuentre con pDer. Por su parte, 
	 * pDer retrocederá desde la posición N-1 hasta que no se encuentre con pIzq. De esta forma,
	 * la función es capaz de resistir espacios arbitrarios y caracteres que no sean letras.
	 * @param cadena
	 * @return
	 */
	public boolean esPalindromo(String cadena) {
		int pIzq = 0;
		int pDer = cadena.length() - 1;
		
		if( cadena == "" ) { // la cadena vacía se considera palindromo
			return true;
		}
		
		// la cadena se pasa a minusculas para su comparacion
		cadena = cadena.toLowerCase();
		
		// mientras los punteros no se encuentren
		while( pIzq < pDer ) {
			if( !esCaracter( cadena.charAt(pIzq) ) ) { // mientras el caracter de la izquierda no sea letra, avanza el puntero 
				pIzq++;
				continue; // avanza el ciclo a su siguiente iteración (No se rompe ni, se sale del ciclo while)
			}
			
			if( !esCaracter( cadena.charAt(pDer) )) { // mientras el caracter de la derecha no sea letra, recorre el puntero una posición atrás
				pDer--;
				continue; // avanza el ciclo a su siguiente iteración (No se rompe ni, se sale del ciclo while)
			} 
			
			if( cadena.charAt(pIzq) == cadena.charAt(pDer) ) { // si ambos caracters son igules, 
				pIzq++;
				pDer--;
				continue; // avanza el ciclo a su siguiente iteración (No se rompe ni, se sale del ciclo while)
			}else {
				return false; // la palabra no es palindromo. Aquí sí se sale del ciclo while
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Ejercicio11 ejercicio = new Ejercicio11();
		
		System.out.println("Ingrese una cadena para ver si es palindromo: ");
		String test = Util.capturaCadena();
		System.out.println(test + " \t\t\tes palindromo?\t\t" + ejercicio.esPalindromo(test));
		
		System.out.println("\n\nOtras cadenas de ejemplo\n");
		
		final String[] cadenas = {
				"somos o no somos",
				"s o m o s o n o s o m o s",
				"   s     o m o s o     n o s o m o    s",
				"Alli ves, Sevilla",
				"",
				"Asi, Maria, raparas a Sara para ir a misa",
				"Anita lava la tina",
				"Esta no es palindromo",
				"esta tampoco",
		};
		
		for(String prueba : cadenas) {
			System.out.println(prueba + " \t\t\tes palindromo?\t\t" + ejercicio.esPalindromo(prueba));
		}
	}
}
