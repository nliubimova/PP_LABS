import java.util.Scanner;
import java.io.*;
import java.io.File;


public class Main {
    public static void main(String[] args) throws IOException {

        //input (files)
        Scanner scanner = new Scanner(new File("input.txt"));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matr[i][j] = scanner.nextInt();
            }
        }
        //initialization
        int min = matr[0][0];
        int max = matr[0][0];
        int index_min = 0;
        int index_max = 0;

        //creates new matrix
        int[][] matr1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matr1[i][j] = matr[i][j];
            }
        }

        //finds the smallest element of matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (min >= matr[i][j]) {
                    min = matr[i][j];
                    index_min = i;
                }
            }

        }

        //finds the biggest element of matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max <= matr[i][j]) {
                    max = matr[i][j];
                    index_max = i;
                }
            }

        }

        //changes lines
        int[] temp;
        temp = matr [index_min];
        matr[index_min]=matr[index_max];
        matr[index_max]=temp;


        //output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.print("\n");
        }


        //finds the biggest number in line, if 0 belongs to the main diagonal
        int max_withzero = matr[0][0];
        boolean found_zero = false;
        for (int i = 0; i < n; i++) { //the smallest element
            max_withzero = matr1[i][0];
            found_zero = false;
            for (int j = 0; j < m; j++) {
                if (max_withzero <= matr1[i][j]) {
                    max_withzero = matr1[i][j];
                }
                if (i == j && matr1[i][j] == 0) {
                    System.out.println("The line with zero on main diagonal is " + i);
                    found_zero = true;
                }
            }
            if (found_zero) {
                System.out.println("And max element is " + max_withzero);
            }
        }

    }

    }






