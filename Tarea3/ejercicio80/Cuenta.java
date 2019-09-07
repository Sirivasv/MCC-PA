package ejercicio80;

public class Cuenta {
    private String nombre;
    private String numeroCuenta;
    private double saldo;

    public Cuenta() {
        nombre = "";
        numeroCuenta = "";
        saldo = 0.0;
    }

    public Cuenta(String nombre, String numeroCuenta, double saldo) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String nuevoNumeroCuenta) {
        numeroCuenta = nuevoNumeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double nuevoSaldo) {
        saldo = nuevoSaldo;
    }

    public boolean ingreso(double cantidadIngreso) {
        if (0.0 > cantidadIngreso) {
            return false;
        }

        this.saldo = this.saldo + cantidadIngreso;
        return true;
    }

    public boolean reintegro(double cantidadReintegro) {
        if (0.0 > cantidadReintegro) {
            return false;
        }
        if (this.saldo < cantidadReintegro) {
            return false;
        }

        this.saldo = this.saldo - cantidadReintegro;
        return true;
    }

    public boolean transferencia(Cuenta cuentaDestino, double cantidadTransferencia) {
        if (0.0 > cantidadTransferencia) {
            return false;
        }

        if (this.saldo >= cantidadTransferencia) {
            this.reintegro(cantidadTransferencia);
            cuentaDestino.ingreso(cantidadTransferencia);
        }
        return true;
    }

}