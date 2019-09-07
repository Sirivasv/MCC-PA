package ejercicio77;

public class Circulo {

    private static final float numeroPi = 3.1416f;
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public float getNumeroPi() {
        return numeroPi;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double nuevoRadio) {
        radio = nuevoRadio;
    }

    public double calculaArea() {
        return numeroPi * (radio * radio);
    }

    public double calculaLongitud() {
        return numeroPi * 2f * radio;
    }

}