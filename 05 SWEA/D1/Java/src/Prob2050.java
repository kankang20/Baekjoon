
/**
* title  : 2050. 알파벳을 숫자로 변환 (D1)
* time   : 117ms
* memory : 17428kb
*/

import java.io.*;
 
public class Prob2050 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i) - 'A' + 1).append(" ");
        }

        System.out.println(sb);
    }
}
