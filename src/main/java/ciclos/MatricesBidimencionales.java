package ciclos;

import javax.swing.*;

public class MatricesBidimencionales {

    public static void main(String[] args) {

        int dimensionUno = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la primera matriz"));
        int dimensionDos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la segunda matriz"));

        //Matriz de dos dimension
        int [][] matrix = new int[dimensionUno][dimensionDos]; // 2x3

        //Cargando la matriz
        for (int i = 0; i < dimensionUno; i++) {
            for (int j = 0; j < dimensionDos; j++) {
                matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los datos de la matriz"));
            }
        }

        //  matrix[0][0] = 1;
        //  matrix[0][1] = 2;
        //  matrix[0][2] = 3;
        //
        //  matrix[1][0] = 4;
        //  matrix[1][1] = 5;
        //  matrix[1][2] = 6;

        //Recorrer matriz con for tradicionales
        for (int i = 0; i < dimensionUno; i++) {
            for (int j = 0; j < dimensionDos; j++) {
                System.out.print (matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");

        //Forma de cargar la matriz
        int[][] matrix2 = {
            {1,2,3,4,5,6,7,8,9},
            {11,22,33,44,55,66,77,88,99},
            {111,222,333,444,555,666,777,888,999}
        };

        //Recorrer matriz con for each
        for (int[] fila : matrix2){
            System.out.println();
            for (int dato : fila){
                System.out.print(dato + " ");
            }
        }



    }
}
