package mx.unam.progavanzada.tareapractica.ejercicio16;

public class Caballo extends Animal implements Hervivoro {
    @Override
    public void comunicar() {
        System.out.println("RjEEeeEEeEey");
    }

    public void comerHierba() {
        System.out.println("Caballo Come Hierba");
    }
}