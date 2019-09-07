package ejercicio80;
public class Principal {

    public static void main(String[] args) {
       
        //se crea objeto cuenta1 sin parámetros, se ejecuta el constructor por defecto
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setNombre("Mario");
        cuenta1.setNumeroCuenta("78585942069");
        cuenta1.setSaldo(100);
        
        //se crea el objeto cuenta2, se ejecuta el constructor con parámetros
        Cuenta cuenta2 = new Cuenta("Juan Ferrández Rubio", "12345678901234567890", 300);
        
        //mostrar los datos de cuenta1
        System.out.println("Datos de la cuenta 1");
        System.out.println("Nombre del titular: " + cuenta1.getNombre());
        System.out.println("Número de cuenta: " + cuenta1.getNumeroCuenta());
        System.out.println("Saldo: " + cuenta1.getSaldo());
        System.out.println();
               
        //se realiza un ingreso en cuenta1
        cuenta1.ingreso(4000);
               
        //mostrar el saldo de cuenta1 después del ingreso
        System.out.println("Saldo después de ingreso de 4000 a la cuenta 1: " + cuenta1.getSaldo());
               
        //se intenta ingresar saldo negativo
        cuenta1.ingreso(-40);

        //mostrar el saldo de cuenta1 después del ingreso
        System.out.println("Saldo después de ingreso de -40 a la cuenta 1: " + cuenta1.getSaldo());
        System.out.println();

        //mostrar los datos de cuenta2
        System.out.println("Datos de la cuenta 2");
        System.out.println("Nombre del titular: " + cuenta2.getNombre());
        System.out.println("Número de cuenta: " + cuenta2.getNumeroCuenta());
        System.out.println("Saldo: " + cuenta2.getSaldo());
        System.out.println();
        
        //realizar un reintegro de 20 a la cuenta2
        cuenta2.reintegro(20);
        System.out.println("Saldo después de reintegro de 20 a la cuenta 2: " + cuenta2.getSaldo());
        System.out.println();

        //realizar un reintegro de 10000 a la cuenta2
        cuenta2.reintegro(10000);
        System.out.println("Saldo después de reintegro de 10000 a la cuenta 2: " + cuenta2.getSaldo());
        System.out.println();

        //realizar un reintegro de -10 a la cuenta2
        cuenta2.reintegro(-10);
        System.out.println("Saldo después de reintegro de -10 a la cuenta 2: " + cuenta2.getSaldo());
        System.out.println();

        //realizar una transferencia de 10 desde cuenta1 a cuenta2
        cuenta1.transferencia(cuenta2, 10);
               
        //mostrar el saldo de cuenta2
        System.out.println("Saldo de la cuenta 2 depués de la transferencia por la cantidad de 10 de la cuenta 1");
        System.out.println("Saldo: " + cuenta2.getSaldo());
        System.out.println();
               
        //mostrar el saldo de cuenta1
        System.out.println("Saldo de la cuenta 1 depués de la transferencia por la cantidad de 10 a la cuenta 2");
        System.out.println("Saldo: " + cuenta1.getSaldo());
        System.out.println();
    }

}