package mx.unam.progavanzada.practica.ejercicio10;

import mx.unam.progavanzada.practica.Util;

/**
 * Imprimir los dígitos de un número dado en orden inverso.
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Sep 26, 2019, 7:59:10 PM
 *
 */
public class Ejericio10 {
	/**
	 * Inversión del orden manejando el número completo como
	 * una cadena. Uso de la función {@link String#charAt(int)}.
	 * Se maneja como una cadena ya que si el número a invertir es 
	 * 1000, el resultado deberá ser 0001. Si se empleará un tipo de 
	 * dato entero, el resultado sería 1.
	 * @param num
	 * @return
	 */
	public String invertirNumero(int num) {
		/* 
		 * el número recibo se convierte a cadena para poder 
		 * manejar las posiciones de sus caracteres
		 */
		String strNum = String.valueOf(num);
		int extension = strNum.length();
		
		StringBuffer sb = new StringBuffer();
		
		for( int i = extension - 1; i >=0; i-- ) {
			sb.append(strNum.charAt(i));
		}
		
		// Conversión de la cadena de texto a su equivalente numérico
		return  sb.toString();
	}
	
	public static void main(String[] args) {
		Ejericio10 ejercicio = new Ejericio10();
		
		System.out.println("Ingrese un número: ");
		int numero = Util.capturaNumero();
		System.out.println( ejercicio.invertirNumero(numero) );
	}
}
