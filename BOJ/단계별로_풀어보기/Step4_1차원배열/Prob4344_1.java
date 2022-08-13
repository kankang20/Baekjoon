package BOJ.단계별로_풀어보기.Step4_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 176ms 15564KB

public class Prob4344_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
    
        for (int i = 0; i < num; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int number = Integer.parseInt(st.nextToken());
            int[] intArray = new int[number];
            
            int sum = 0;
            float average = 0;
            int count = 0;

            for (int j = 0; j < number; j++) {
                intArray[j] = Integer.parseInt(st.nextToken());
                sum += intArray[j];
            }

            average = sum / (float)number;

            for (int j : intArray) {
                if (j > average) {
                    count++;
                }
            }

            sb.append(String.format("%.3f", count/(float)number*100) + "%\n");
        }

        System.out.println(sb);

        br.close();
    }
}