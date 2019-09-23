package mx.unam.progavanzada.tareapractica.ejercicio16;

public class Ejercicio16 {
    
    public static void hablarConAnimal(Animal a) {
        a.comunicar();
    }

    public static void main(String args[]) {
        
        Caballo caballo1 = new Caballo();
        Tigre tigre1 = new Tigre();
        Vaca vaca1 = new Vaca();
        System.out.println("Hablando con caballo: ");
        Ejercicio16.hablarConAnimal(caballo1);
        System.out.println("Hablando con tigre: ");
        Ejercicio16.hablarConAnimal(tigre1);
        System.out.println("Hablando con vaca: ");
        Ejercicio16.hablarConAnimal(vaca1);

        System.out.println("Los animales comen: ");
        caballo1.comerHierba();
        tigre1.comerCarne();
        vaca1.comerHierba();

    }
}