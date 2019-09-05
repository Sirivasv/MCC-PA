package Parte2;

public class Principal {

    public static void main(String[] args) {

        Persona persona1 = new Persona("José");
        Persona persona2 = new Persona(1.74f);
        Persona persona3 = new Persona(23);
        Persona persona4 = new Persona("María", 30, 1.6f);

        persona1.describir();
        persona2.describir();
        persona3.describir();
        persona4.describir();

        persona1.setEdad(25);
        persona1.setEstatura(1.9f);
        
        persona2.setNombre("Rene");
        persona2.setEdad(27);
        
        persona3.setNombre("Ana");
        persona3.setEstatura(1.8f);
        
        System.out.println("");
        persona1.describir();
        persona2.describir();
        persona3.describir();
        persona4.describir();

    }

}