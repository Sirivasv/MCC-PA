package mx.unam.progavanzada.tareapractica.ejercicio11;

import java.util.Scanner;

public class Ejercicio11 {

    public static int recorreIndice(int variacion, int pos, String cadena) {
        while ((pos >= 0) && (pos < cadena.length()) && (!Character.isLetter(cadena.charAt(pos)))) {
            pos += variacion;
        }
        return pos;
    }

    public static void main(String args[]) {
        int entrada_valida = 1;
        Scanner sc = new Scanner(System.in);
        String palabra_entrada = "";
        do{ 

            try {
            
                System.out.print("Introduce la palabra: ");
                palabra_entrada = sc.nextLine();               
                entrada_valida = 1;
                
            } catch(Exception e) {
                entrada_valida = 0;
                sc.next();
                System.out.println("El valor que introdujiste no es válido");
            }

        }while(entrada_valida != 1);
                
        String evaluacion = "SI";

        int ini = 0; int fin = palabra_entrada.length() - 1;
        ini = recorreIndice(1, ini, palabra_entrada);
        fin = recorreIndice(-1, fin, palabra_entrada);
        while (ini <= fin) {
            if (Character.toUpperCase(palabra_entrada.charAt(ini)) != Character.toUpperCase(palabra_entrada.charAt(fin))) {
                evaluacion = "NO";
                break;
            }
            ini = recorreIndice(1, ini + 1, palabra_entrada);
            fin = recorreIndice(-1, fin - 1, palabra_entrada);
        }

        System.out.println("La palabra introducida " + evaluacion + " es un palindromo.");
    }
}