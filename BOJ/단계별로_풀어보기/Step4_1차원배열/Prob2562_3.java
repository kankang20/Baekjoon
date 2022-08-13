package BOJ.단계별로_풀어보기.Step4_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 152ms 16036KB

public class Prob2562_3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int[] intArray = new int[9];

        for(int i = 0; i < 9; i++) {
            intArray[i] = Integer.parseInt(br.readLine());
        }

        int max = intArray[0], count = 1;

        for(int i = 1; i < 9; i++) {

            if (intArray[i] > max) {
                max = intArray[i];
                count = i+1;
            }

        }
        
        System.out.println(max + "\n" + count);

        br.close();
    }
}