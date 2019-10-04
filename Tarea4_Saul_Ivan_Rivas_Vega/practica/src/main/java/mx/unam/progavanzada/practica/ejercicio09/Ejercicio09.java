package mx.unam.progavanzada.practica.ejercicio09;

import mx.unam.progavanzada.practica.Util;

/**
 * Promedio de N números
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Sep 26, 2019, 7:28:17 PM
 *
 */
public class Ejercicio09 {
	/**
	 * Cálculo del promedio de los números contenidos en 
	 * un arreglo.
	 * @param numeros
	 * @return
	 */
	public float calularPromedio(int[] numeros) {
		float suma = 0;
		
		for(int i=0; i<numeros.length;i++) {
			suma += numeros[i];
		}
		
		float promedio = suma / numeros.length;
		return promedio;
	}
	
	public static void main(String[] args) {
		Ejercicio09 ejercicio = new Ejercicio09();
		
		System.out.println("Ingrese el número de elementos a promediar:");
		int n = Util.capturaNumero();
		
		// inicialización del arreglo de números a promediar
		int[] entradas = new int[n];
		
		for(int i=0; i<n; i++) {
			System.out.println("Ingrese el número en la posición " + (i + 1) + ": ");
			entradas[i] = Util.capturaNumero();
		}
		
		float promedio = ejercicio.calularPromedio(entradas);
		System.out.println("Promedio: " + promedio);
	}
}
