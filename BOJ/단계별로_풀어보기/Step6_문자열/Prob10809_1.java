package BOJ.단계별로_풀어보기.Step6_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 148ms 16336KB

public class Prob10809_1 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] intArray = new int[26];
        String text = br.readLine();

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = -1;
        }

        for (int i = 0; i < text.length(); i++) {
            if(intArray[(int)text.charAt(i) - 'a'] == -1){
                intArray[(int)text.charAt(i) - 'a'] = i;
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i] + " ");
        }

        System.out.println(sb);
        br.close();
        
    } 
}