package ejercicio77;

import java.util.Scanner;

public class Principal {
    public static void main(String args[]) {

        int entrada_valida = 1;
        Scanner sc = new Scanner(System.in);
        double miRadio = 0.0;
        do{

            try {
            
                System.out.print("Introduce el radio del círculo: ");
                miRadio = sc.nextDouble();
                entrada_valida = 1;
                
            } catch(Exception e) {
                entrada_valida = 0;
                sc.next();
                System.out.println("El valor que introdujiste no es válido");
            }

        }while(entrada_valida != 1);
        
        Circulo miCirculo = new Circulo(miRadio);
        System.out.println("El radio del círculo es: " + miCirculo.getRadio() + " su area es: " + miCirculo.calculaArea() + " y su longitud es: " + miCirculo.calculaLongitud());

    }
}