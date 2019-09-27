package mx.unam.progavanzada.tareapractica.ejercicio14;

import mx.unam.progavanzada.tareapractica.ejercicio13.UsoMatriz;

public class UsoMatrizExtendida extends UsoMatriz {

    public UsoMatrizExtendida() {
        super();
    }

    public void preguntarCambiarValor() {
        int entrada_valida = 0;
        int continuar_preguntando = 1;
        
        do{ 
            int fila = 0;
            int columna = 0;
            int valor = 0;
            
            // Preguntar fila 
            entrada_valida = 0;
            do {
                try {
                
                    System.out.print("Introduce el numero de la fila a cambiar (0 - " + (this.getMatriz().getN() - 1) + ") o bien -1 para terminar: ");
                    fila = this.getScanner().nextInt();    
                    if ((fila < -1) || (fila >= this.getMatriz().getN())) {
                        throw new IllegalArgumentException("El valor de N debe estar en el rango (0 - " + (this.getMatriz().getN() - 1) + ")");                    
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
                    this.getScanner().next();
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
                
                    System.out.print("Introduce el numero de la columna a cambiar (0 - " + (this.getMatriz().getN() - 1) + "): ");
                    columna = this.getScanner().nextInt();    
                    if ((columna <= -1) || (columna >= this.getMatriz().getN())) {
                        throw new IllegalArgumentException("El valor de N debe estar en el rango (0 - " + (this.getMatriz().getN() - 1) + ")");                                       
                    }
                    entrada_valida = 1;

                } catch (IllegalArgumentException e) {
                    entrada_valida = 0;
                    System.out.println(e);
                } catch(Exception e) {
                    entrada_valida = 0;
                    this.getScanner().next();
                    System.out.println("El valor que introdujiste no es válido");
                } 
            }while(entrada_valida != 1);

            // Validar el nuevo valor
            entrada_valida = 0;
            do {
                try {
                
                    System.out.print("Introduce el nuevo valor para la posicion ("+ fila + ", " + columna + "): ");
                    valor = this.getScanner().nextInt();    
                    entrada_valida = 1;

                } catch (IllegalArgumentException e) {
                    entrada_valida = 0;
                    System.out.println(e);
                } catch(Exception e) {
                    entrada_valida = 0;
                    this.getScanner().next();
                    System.out.println("El valor que introdujiste no es válido");
                } 
            }while(entrada_valida != 1);

            //cambio de valor
            this.getMatriz().setValorEn(fila, columna, valor);
            System.out.println("Esta es la matriz despues de colocar " + valor + "en la posicion ("+ fila + ", " + columna + "): ");
            this.imprimeMatriz();


        }while(continuar_preguntando == 1);
    }

}