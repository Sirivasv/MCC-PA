package mx.unam.progavanzada.practica;

import java.util.Scanner;

/**
 * Clase de utilería para leer datos ingresados 
 * en el teclado.
 *
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Sep 26, 2019, 7:32:05 PM
 *
 */
public class Util {
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * Lectura de número entero del teclado
	 * @return
	 */
	public static int capturaNumero() {
		return scan.nextInt();
	}
	
	/**
	 * Lectura de una cadena de texto del taclado.
	 * La función {@link String#trim()} es para remover 
	 * los espacios en blanco del final de la misma.
	 * @return
	 */
	public static String capturaCadena() {
		return scan.nextLine().trim();
	}
}
