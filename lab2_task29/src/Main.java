import java.util.Scanner;
import java.io.*;



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
        int[] firstLine = new int[m];
        for (int i = 0; i < m; i++) {
            firstLine[i]=matr[0][i];
        }
        int l = firstLine.length;
        boolean swapped;
        for (int i = 0; i < l - 1; i++) {
            swapped = false;

            for (int j = 0; j < l - i - 1; j++) {
                if (firstLine[j] > firstLine[j + 1]) {
                    int temp = firstLine[j];
                    firstLine[j] = firstLine[j + 1];
                    firstLine[j + 1] = temp;
                    swapped = true;
                    for (int k = 0; k < matr.length; k++){
                        int buf = matr[k][j];
                        matr[k][j] = matr[k][j+1];
                        matr[k][j+1] = buf;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
        //output
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.print("\n");
        }

    }

    }

