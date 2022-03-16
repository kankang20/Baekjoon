package 단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10809 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 148ms 16336KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] intArray = new int[26];
        String text = br.readLine();

        // OPTION 2 : 148ms 15820KB
        // int num = 0;

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = -1;
        }

        // OPTION 3 : 152ms 16256KB
        // Arrays.fill(intArray, -1);   // 배열 초기화

        for (int i = 0; i < text.length(); i++) {
            if(intArray[(int)text.charAt(i) - 'a'] == -1){
                intArray[(int)text.charAt(i) - 'a'] = i;
            }

            /** OPTION 2 
            num = (int)text.charAt(i) - 'a';
            
            if(intArray[num] == -1){
                intArray[num] = i;
            }
             */
        }

        for (int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i] + " ");
        }

        System.out.println(sb);
        br.close();
        
    } 
}
