package mx.unam.progavanzada.tareapractica.ejercicio10;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String args[]) {
        int entrada_valida = 1;
        Scanner sc = new Scanner(System.in);
        String numero_entrada = "";
        do{ 

            try {
            
                System.out.print("Introduce el numero: ");
                numero_entrada = sc.nextLine();               
                entrada_valida = 1;
                
            } catch(Exception e) {
                entrada_valida = 0;
                sc.next();
                System.out.println("El valor que introdujiste no es válido");
            }

        }while(entrada_valida != 1);
                
        System.out.print("El numero con los digitos en orden inverso es: ");
        for (int i = numero_entrada.length() - 1; i >= 0; i--) {
            System.out.print(numero_entrada.charAt(i));
        }
        System.out.println();
    }
}