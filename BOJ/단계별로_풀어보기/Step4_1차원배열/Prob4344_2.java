package BOJ.단계별로_풀어보기.Step4_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 176ms 15812KB

public class Prob4344_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
    
        for (int i = 0; i < num; i++) {

            String[] stringArray = br.readLine().split(" ");
            
            int sum = 0;
            int count = 0;

            for (int j = 1; j < stringArray.length; j++) {
                sum += Integer.parseInt(stringArray[j]);
            }

            float average = sum / Float.parseFloat(stringArray[0]);

            for (int j = 1; j < stringArray.length; j++) {
                if (Integer.parseInt(stringArray[j]) > average) {
                    count++;
                }
            }

            sb.append(String.format("%.3f", count/Float.parseFloat(stringArray[0])*100) + "%\n");
        }

        System.out.println(sb);

        br.close();
    }
}