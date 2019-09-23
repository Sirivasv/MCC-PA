package mx.unam.progavanzada.tareapractica.ejercicio13;

public class Matriz {
    
    private int[][] matriz;
    private int n;

    public Matriz(int tam) {
        this.n = tam;
        matriz = new int[n][n];
        int id = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matriz[i][j] = id;
                id++;
            }
        }

    }

    public int[][] getMatriz() {
        return matriz;
    }

    public String toString() {
        StringBuffer res = new StringBuffer("");
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                res.append(matriz[i][j]);
                res.append(' ');
            }
            res.append('\n');
        }

        return res.toString();
    }

    public int getValorEn(int pos_i, int pos_j) {
        return matriz[pos_i][pos_j];
    }

    public int getN() {
        return n;
    }

    public void setValorEn(int pos_i, int pos_j, int valor) {
        matriz[pos_i][pos_j] = valor;
    }

}