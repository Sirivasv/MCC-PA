package mx.unam.progavanzada.tareapractica.ejercicio13;

import java.util.Scanner;

public class UsoMatriz {

    private Matriz m;
    private Scanner sc;
    
    public UsoMatriz() {
        sc = new Scanner(System.in);
    }

    public Scanner getScanner() { 
        return this.sc;
    }
    
    public Matriz getMatriz() {
        return this.m;
    }

    public void leerN() {
        int entrada_valida = 1;
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

        this.m = new Matriz(n);
    }

    public void imprimeMatriz() {
        System.out.println("Esta es la matriz de " + this.m.getN() + " x " + this.m.getN() + " elementos:");
        System.out.println(this.m);
    }

}