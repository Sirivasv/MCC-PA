package testEx;

public class Reactivo2 {
    public static void main(String args[]) {
        int x = 0, y = 10;

        try {
            y /= x;
        }
        catch(Exception e) {
            System.err.println("Error");
        }
    }
}
