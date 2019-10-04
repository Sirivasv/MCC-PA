package mx.unam.progavanzada.practica.ejercicio13y14;

import mx.unam.progavanzada.practica.Util;

public class Ejercicio13Matriz {
	private int[][] matriz;

	/**
	 * Constructor para inicializar la matriz
	 * @param n
	 */
	Ejercicio13Matriz(int n) {
		matriz = new int[n][n];
		int contador = 0;
		// Asignamos los valores a sus entradas con un contador
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				matriz[i][j] = contador;
				++contador;
			}
		}
	}

	public void imprimir() {
		String acumulador;
		for (int[] x : matriz) {
			acumulador = "";
			for (int y : x) {
				acumulador = acumulador + y + "\t";
			}
			System.out.println(acumulador);
		}
	}
	
	/**
	 * Método getter de la matriz
	 * @return
	 */
	public int[][] getMatriz() {
		return matriz;
	}

	public static void main(String[] args) {
		System.out.println("Tamaño de la matriz cuadrada: ");
		int n = Util.capturaNumero();
		 
		if (n > 0) { // Validación de que el tamaño de la matriz sea válido
			Ejercicio13Matriz m = new Ejercicio13Matriz(n);
			m.imprimir(); // Imprimimos la matriz
		} else if (n < 0) {
			System.out.println("El valor no es valido, debe ser un numero entero positivo"); 
		}
	}
}
