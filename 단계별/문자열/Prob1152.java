package 단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1152 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 268ms 25392KB
        // TO 문자열을 배열 형태로 받지 않고 string 형태로 받아서 확인하는 코드 가능

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
