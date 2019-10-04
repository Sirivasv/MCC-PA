package mx.unam.progavanzada.practica.ejercicio12;

import mx.unam.progavanzada.practica.Util;

/**
 * Cambio del formato de las letras de una cadena.
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Sep 26, 2019, 8:59:08 PM
 *
 */
public class Ejercicio12 {
	/**
	 * 
	 * @param palabra
	 * @return
	 */
	private String cambiarFormatoPalabra(String palabra) {
		StringBuffer buffer = new StringBuffer();
		
		for(int i=0; i<palabra.length();i++) {
			if( i%2 == 0 ) { // posicion par
				buffer.append( Character.toUpperCase( palabra.charAt(i)) );
			}else { // posición impar
				buffer.append( Character.toLowerCase( palabra.charAt(i)) );
			}
		}
		return buffer.toString();
	}
	
	/**
	 * El formato solicitado hace que se alterne entre mayúsculas y minúsculas
	 * de forma independientemente entre cada palabra, es decir, primero hay que 
	 * separar la frase en palabras tomando como criterio el espacio en blanco.
	 * @param frase
	 * @return
	 */
	public String cambiarFormatoFrase(String frase) {
		// separación de la frase en palaras
		String[] palabras = frase.split(" ");
		String nuevaFrase = "";
		
		int indice = 0;
		
		for( ; indice<palabras.length-1; indice++) {
			nuevaFrase += cambiarFormatoPalabra(palabras[indice]) + " ";
		}
		
		/* 
		 * la última palabra de se excluye del ciclo para que no se le concatene 
		 * un espacio en blanco. Otra forma de resolverlo es procesar todo dentro 
		 * del ciclo for y al salir de él, hacer nuevaFrase.trim();  
		 */
		nuevaFrase += cambiarFormatoPalabra(palabras[indice]);
		
		return nuevaFrase;
	}
	
	public static void main(String[] args) {
		Ejercicio12 ejercicio = new Ejercicio12();
		
		String []frasesDePrueba = new String[] {
				"ejemplo",
				"esta es una frase muy larga",
				"hola mundo",
				"me gusta el cereal",
				"DETESTO LOS LUNES",
				"mi nombre es Juanito",
				"I couldnt repair your brakes so I made your horn louder"
		};
		
		System.out.println("Ingresa una cadena de texto: ");
		String cadena = Util.capturaCadena();
		System.out.println(cadena + " -> " + ejercicio.cambiarFormatoFrase(cadena));
		
		System.out.println("\nAlgunas cadenas de ejemplo.\n");
		for( String frase : frasesDePrueba ) {
			System.out.println(frase + " -> " + ejercicio.cambiarFormatoFrase(frase) );
		}
	}
}
