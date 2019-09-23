package mx.unam.progavanzada.tareapractica.ejercicio16;

public class Tigre extends Animal implements Carnivoro{
    @Override
    public void comunicar() {
        System.out.println("Rwaar");
    }
    public void comerCarne() {
        System.out.println("Tigre Come Carne");
    }
}