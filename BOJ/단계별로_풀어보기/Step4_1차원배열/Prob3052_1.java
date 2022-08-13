package BOJ.단계별로_풀어보기.Step4_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 132ms 14188KB

public class Prob3052_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] intArray = new int[10];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            intArray[i] = Integer.parseInt(br.readLine()) % 42;
        }

        for (int i = 0; i < 10; i++) {
            
            int dupli = 0;
            
            for (int j = i+1; j < 10; j++) {
                if (intArray[i] == intArray[j]){
                    dupli++;
                }
            }

            if (dupli == 0) {
                count++;
            }
        }

        sb.append(count);
        System.out.println(sb);

        br.close();
    }
}
