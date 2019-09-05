package Parte2;

public class Persona {
    private String nombre;
    private int edad;
    private float estatura;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(float estatura) {
        this.estatura = estatura;
    }

    public Persona(int edad) {
        this.edad = edad;
    }

    public Persona(String nombre, int edad, float estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    public void describir() {
        System.out.println(nombre + " tiene " + edad + " años y mide " + estatura + " metros.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

}