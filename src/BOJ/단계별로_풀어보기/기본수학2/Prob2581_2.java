package BOJ.단계별로_풀어보기.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 소수 200ms 16136KB

public class Prob2581_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number1 = Integer.parseInt(br.readLine());
        int number2 = Integer.parseInt(br.readLine());

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

            int sum = 0;

            for (int i : List) {
                sum += i;
            }

            sb.append(sum + "\n" + List.get(0));
        }

        System.out.println(sb);
        br.close();
    }
}