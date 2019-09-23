package mx.unam.progavanzada.tareapractica.ejercicio13;

import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String args[]) {
        int entrada_valida = 1;
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do{ 

            try {
            
                System.out.print("Introduce el numero N (mayor a 0): ");
                n = sc.nextInt();    
                if (n <= 0) {
                    throw new IllegalArgumentException("El valor de N debe ser mayor a 0.");                    
                } 
                entrada_valida = 1;
                
            } catch (IllegalArgumentException e) {
                entrada_valida = 0;
                System.out.println(e);
            } catch(Exception e) {
                entrada_valida = 0;
                sc.next();
                System.out.println("El valor que introdujiste no es válido");
            } 

        }while(entrada_valida != 1);
        
        Matriz miMatriz = new Matriz(n);

        System.out.println("Esta es la matriz de " + n + " x " + n + " elementos:");
        System.out.println(miMatriz);

    }
}