package 단계별.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob10757 {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        // OPTION 1 : 248ms 17236KB

        // BigInteger BigNum1 = new BigInteger(str.nextToken());
        // BigInteger BigNum2 = new BigInteger(str.nextToken());

        // sb.append(BigNum1.add(BigNum2));

        // FIX  왜 정답이 아닌지 이유를 모르겠음. 실행 결과는 잘 나오는거 같은데
        // OPTION 2 : 

        String num1 = str.nextToken();
        String num2 = str.nextToken();

        int max = Math.max(num1.length(), num2.length());

        int[] List1 = new int[max];
        int[] List2 = new int[max];

        for (int i = 0; i < num1.length(); i++) {
            List1[max - 1 - i] = num1.charAt(i) - '0';
        }

        for (int i = 0; i < num2.length(); i++) {
            List2[max - 1 - i] = num2.charAt(i) - '0';
        }

        int[] LastList = new int[max + 1];

        for (int i = 0; i < max; i++) {
            int sum = List1[i] + List2[i];

            LastList[i+1] += sum / 10;
            LastList[i] += sum % 10;
        }

        if (LastList[max] != 0) {
            sb.append(LastList[max]);
        }

        for (int i = max-1; i >= 0; i--) {
            sb.append(LastList[i]);
        }

        System.out.println(sb);
        br.close(); 
    }
}
