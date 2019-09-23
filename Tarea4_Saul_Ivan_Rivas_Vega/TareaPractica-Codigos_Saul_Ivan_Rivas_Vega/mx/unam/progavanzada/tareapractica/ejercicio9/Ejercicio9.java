package mx.unam.progavanzada.tareapractica.ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String args[]) {
        int entrada_valida = 1;
        Scanner sc = new Scanner(System.in);
        int n = 0;
        double arreglo_numeros[] = new double[0];
        do{ 

            try {
            
                System.out.print("Introduce La cantidad de Numeros: ");
                n = sc.nextInt();
                
                System.out.print("Introduce La lista de " + n + " Numeros: ");
                arreglo_numeros = new double[n];
                for (int i = 0; i < n; ++i) {
                    arreglo_numeros[i] = sc.nextDouble();
                }
                entrada_valida = 1;
                
            } catch(Exception e) {
                entrada_valida = 0;
                sc.next();
                System.out.println("El valor que introdujiste no es válido");
            }

        }while(entrada_valida != 1);
        
        double promedio = 0.0;
        for (int i = 0; i < n; ++i) {
            promedio += arreglo_numeros[i];
        }
        promedio /= (double)n;
        
        System.out.println("El promedio de los numeros introducidos es: " + promedio);
    }
}