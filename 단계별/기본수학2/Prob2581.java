package 단계별.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Prob2581 {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number1 = Integer.parseInt(br.readLine());
        int number2 = Integer.parseInt(br.readLine());

        // OPTION 1 : 176ms 16056KB

        int min = number2;
        int sum = 0;

        for (int i = number1; i <= number2; i++) {

            if (i >= 2) {

                boolean check = true;

                for (int j = 2; j < i; j++) {
                    
                    if (i % j == 0) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    sum += i;

                    if (i < min) {
                        min = i;
                    }
                }
            }
        }

        if (sum == 0) {
            sb.append(-1);
        } else {
            sb.append(sum + "\n" + min);
        }

        // OPTION 2 : 200ms 16136KB

        ArrayList<Integer> List = new ArrayList<>();

        for (int i = number1; i <= number2; i++) {

            if (i >= 2) {

                boolean check = true;

                for (int j = 2; j < i; j++) {
                    
                    if (i % j == 0) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    List.add(i);
                }
            }
        }

        if (List.isEmpty()) {
            sb.append(-1);
        } else {

            int List_sum = 0;

            for (int i : List) {
                List_sum += i;
            }

            sb.append(List_sum + "\n" + List.get(0));
        }
        
        System.out.println(sb);
        br.close(); 
    }
}
