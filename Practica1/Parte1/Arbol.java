package Parte1;

public class Arbol {
    
    public Arbol() {
        System.out.println("Un árbol genérico");
    }
    
    public Arbol(String tipo) {
        System.out.println("Un árbol tipo: " + tipo);
    }

    public Arbol(int altura) {
        System.out.println("Un árbol de " + altura + " metros");
    }

    public Arbol (int altura, String tipo) {
        System.out.println("Un " + tipo + " de " + altura + " metros");
    }

}