package BOJ.단계별로_풀어보기.Step6_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 264ms 25320KB

public class Prob1152_1 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] stringArray = br.readLine().split(" ");
        int count = stringArray.length;

        for (int i = 0; i < stringArray.length; i++) {
            if(stringArray[i].isEmpty()) {
                count--;
            }
        }

        sb.append(count);

        System.out.println(sb); 
        br.close();
    } 
}