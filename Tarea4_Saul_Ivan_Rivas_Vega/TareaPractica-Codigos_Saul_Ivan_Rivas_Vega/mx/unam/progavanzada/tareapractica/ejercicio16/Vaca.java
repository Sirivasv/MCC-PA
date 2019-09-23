package mx.unam.progavanzada.tareapractica.ejercicio16;

public class Vaca extends Animal implements Hervivoro{
    @Override
    public void comunicar() {
        System.out.println("Muuuu");
    }
    public void comerHierba() {
        System.out.println("Vaca Come Hierba");
    }
}