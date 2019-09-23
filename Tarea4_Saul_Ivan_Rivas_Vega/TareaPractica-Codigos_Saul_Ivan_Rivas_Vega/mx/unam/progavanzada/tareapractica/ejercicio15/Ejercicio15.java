package mx.unam.progavanzada.tareapractica.ejercicio15;

public class Ejercicio15 {
    
    public static void hablarConAnimal(Animal a) {
        a.comunicar();
    }

    public static void main(String args[]) {
        
        Caballo caballo1 = new Caballo();
        Tigre tigre1 = new Tigre();
        Vaca vaca1 = new Vaca();
        System.out.println("Hablando con caballo: ");
        Ejercicio15.hablarConAnimal(caballo1);
        System.out.println("Hablando con tigre: ");
        Ejercicio15.hablarConAnimal(tigre1);
        System.out.println("Hablando con vaca: ");
        Ejercicio15.hablarConAnimal(vaca1);
    }
}