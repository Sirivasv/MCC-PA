package mx.unam.progavanzada.tareapractica.ejercicio14;

import java.util.Scanner;
import mx.unam.progavanzada.tareapractica.ejercicio13.Matriz;

public class Ejercicio14 {
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
        
        int continuar_preguntando = 1;
        do{ 
            int fila = 0;
            int columna = 0;
            int valor = 0;
            
            // Preguntar fila 
            entrada_valida = 0;
            do {
                try {
                
                    System.out.print("Introduce el numero de la fila a cambiar (0 - " + (n - 1) + ") o bien -1 para terminar: ");
                    fila = sc.nextInt();    
                    if ((fila < -1) || (fila >= n)) {
                        throw new IllegalArgumentException("El valor de N debe estar en el rango (0 - " + (n - 1) + ")");                    
                    } 
                    if (fila == -1) {
                        continuar_preguntando = 0;
                        break;
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
            
            // Validar si deja de preguntar
            if (continuar_preguntando == 0) {
                break;
            }

            // Validar columna
            entrada_valida = 0;
            do {
                try {
                
                    System.out.print("Introduce el numero de la columna a cambiar (0 - " + (n - 1) + "): ");
                    columna = sc.nextInt();    
                    if ((columna <= -1) || (columna >= n)) {
                        throw new IllegalArgumentException("El valor de N debe estar en el rango (0 - " + (n - 1) + ")");                                       
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

            // Validar el nuevo valor
            entrada_valida = 0;
            do {
                try {
                
                    System.out.print("Introduce el nuevo valor para la posicion ("+ fila + ", " + columna + "): ");
                    valor = sc.nextInt();    
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

            //cambio de valor
            miMatriz.setValorEn(fila, columna, valor);
            System.out.println("Esta es la matriz despues de colocar " + valor + "en la posicion ("+ fila + ", " + columna + "): ");
            System.out.println(miMatriz);


        }while(continuar_preguntando == 1);

    }
}