package mx.unam.progavanzada.tareapractica.ejercicio12;

import java.util.Scanner;

public class Ejercicio12 {

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
                
        StringBuffer resultado = new StringBuffer("");

        int ini = 0;
        int ponerMayus = 1;
        int anterior_ini = ini;
        ini = recorreIndice(1, ini, palabra_entrada);
        if (anterior_ini != ini) {
            resultado.append(palabra_entrada.substring(anterior_ini, ini));
        }
        while (ini < palabra_entrada.length()) {
            if (ponerMayus == 1) {
                resultado.append(Character.toUpperCase(palabra_entrada.charAt(ini)));
                ponerMayus = 0;
            } else {
                resultado.append(Character.toLowerCase(palabra_entrada.charAt(ini)));
                ponerMayus = 1;
            }
            anterior_ini = ini + 1;
            ini = recorreIndice(1, ini + 1, palabra_entrada);
            if (anterior_ini != ini) {
                resultado.append(palabra_entrada.substring(anterior_ini, ini));
                ponerMayus = 1;
            }
        }

        System.out.println("Palabra de salida: " + resultado);
    }
}