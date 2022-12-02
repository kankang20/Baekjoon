package BOJ.단계별로_풀어보기.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 알파벳 찾기 152ms 16256KB

public class Prob10809_3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] intArray = new int[26];
        String text = br.readLine();

        int num = 0;

        Arrays.fill(intArray, -1);

        for (int i = 0; i < text.length(); i++) {
            num = (int) text.charAt(i) - 'a';

            if (intArray[num] == -1) {
                intArray[num] = i;
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i] + " ");
        }

        System.out.println(sb);
        br.close();

    }
}