package BOJ.단계별로_풀어보기.Step4_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 128ms 14232KB

public class Prob3052_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] intArray = new int[42];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            intArray[Integer.parseInt(br.readLine()) % 42]++;
        }

        for (int i = 0; i < 42; i++) {
            if(intArray[i] != 0){
                count++;
            }
        }

        sb.append(count);
        System.out.println(sb);

        br.close();
    }
}