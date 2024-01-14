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
        //creates array with elements x2
        int count = 0;
        int number = 0;
        int[] arr = new int[n * m];
        int element;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                element = matr[i][j];
                for (int l = 0; l < n; l++) {
                    for (int q = 0; q < m; q++) {
                        if (element == matr[l][q]) {
                            count++;
                        }

                    }
                }
                if (count == 2) {
                    arr[number] = element;
                    number++;

                }
                count = 0;
            }

        }
        //finds the biggest element in array
        int max_arr = arr[0];
        for (int i = 0; i < m; i++) {
            if (max_arr <= arr[i]) {
                max_arr = arr[i];
            }


        }
        System.out.print("The biggest element that occurs two times is ");
        System.out.print(max_arr);
    }
    }