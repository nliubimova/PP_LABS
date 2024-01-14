import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your text");
        List<String> text = new ArrayList();
        String str = new String();
        String word;
        int len;

        while(true){
            String current = in.nextLine();
            if(current.isEmpty())break;
            text.add(current);
        }
        System.out.println("Enter your k");
        int k = in.nextInt();
        int count = text.size();
        for(int i =0; i<count; i++){
            str = text.get(i);
            if (!str.isEmpty()) {
                StringTokenizer st = new StringTokenizer(str);
                while (st.hasMoreTokens()) {

                    word = st.nextToken();
                    char[] arr = word.toCharArray();
                    len = word.length();
                    for (int j = 0; j < len; j++) {
                        if (j == k - 1) {
                            arr[j] = '*';
                        }
                        System.out.print(arr[j]);


                    }
                    System.out.print(' ');

                }
            }
            System.out.print ('\n');
        }


    }
}