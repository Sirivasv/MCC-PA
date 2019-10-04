package mx.unam.progavanzada.practica.ejercicio13y14;

import mx.unam.progavanzada.practica.Util;

public class Ejercicio14 extends Ejercicio13Matriz {
	private int n;
	
	Ejercicio14(int n) {
		super(n);
		this.n = n;
	}

	/**
	 * Validación de que el índice proporcionado se encuentre entre
	 * [0,n) mediante el uso del operador ternario.
	 * 
	 * Esto es equivalente a emplear la estructura 
	 * <p>
	 * <code><pre>
	 if( indice >= 0 && indice < n ){
	 	return true;
	 }else{
	 	return false;
	 }
	 * </pre></code>
	 * </p>
	 * @param indice
	 * @return
	 */
	private boolean esIndiceValido(int indice){
		return indice >= 0 && indice < n ? true : false;
	}
	
	public void sustituirElemento(int i, int j, int valor) {
		if( esIndiceValido(i) && esIndiceValido(j) ) {
			getMatriz()[i][j] = valor;
		}else {
			System.err.println("La posición [" + i + "][" + j + "] no es válida" );
			/* 
			 * Finalización anticipada el programa indicando que hay un error.
			 * Por convención, cualquier programa o comando termina con un código 0
			 * para indicar que finalizó correctamente, en caso contrario, se devuelve
			 * cualquier otro número. 
			 */
			System.exit(1); 
		}
	}
	
	public static void main(String []args) {
		System.out.println("Ingrese un número");
		int numeroUsuario = Util.capturaNumero();
		
		if (numeroUsuario > 0) { // Validación de que el tamaño de la matriz sea válido
			Ejercicio14 ejercicio = new Ejercicio14(numeroUsuario);
			ejercicio.imprimir();
			
			System.out.println("Ingrese i: ");
			int i = Util.capturaNumero();
			
			System.out.println("Ingrese j: ");
			int j = Util.capturaNumero();
			
			System.out.println("Ingrese el nuevo valor:");
			int valor = Util.capturaNumero();
			
			ejercicio.sustituirElemento(i, j, valor);
			ejercicio.imprimir();
		}else {
			System.err.println("El número " + numeroUsuario + " no es válido. Ingrese un número entero positivo mayor o igual a 1");
		}
	}
}
