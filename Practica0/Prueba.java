class Test{
    int identificador;
    int edad;
    public Test(int id, int edad) {
        identificador = id;
        this.edad = edad;
    }   
    public String toString() {
        return "Test> identificador: " + this.identificador + " edad: " + this.edad;
    }
}

class UnitTest extends Test {
    int unitID;
    
    public UnitTest(int id, int edad, int unitID) {
        super(id, edad);
        this.unitID = unitID;
    }

    public void modifyIdentificador(int id) {
        this.identificador = id;
    }

    public void testModify() {
        Test pruebaTest = new Test(0, 0);
        pruebaTest.edad = 5;
        System.out.println(pruebaTest);
    }

    public String toString() {
        return "Test> identificador: " + this.identificador + " edad: " + this.edad + " unitID: " + this.unitID;
    }
}

public class Prueba {

    public static void main(String[] args) {
        Test my_test = new Test(1, 77);
        System.out.println(my_test);
        UnitTest my_unitTest = new UnitTest(2, 88, 4);
        System.out.println(my_unitTest);
        my_unitTest.modifyIdentificador(3);
        System.out.println(my_unitTest);
        my_unitTest.testModify();
    }

}