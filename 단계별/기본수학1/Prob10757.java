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

        BigInteger BigNum1 = new BigInteger(str.nextToken());
        BigInteger BigNum2 = new BigInteger(str.nextToken());

        sb.append(BigNum1.add(BigNum2));

        // TO 직접 덧셈을 구현하는 방법
        // OPTION 2 : 

        String num1 = str.nextToken();
        String num2 = str.nextToken();

        int max = Math.max(num1.length(), num2.length());

        int[] List1 = new int[max];
        int[] List2 = new int[max];

        int[] LastList = new int[Math.max(num1.length(), num2.length()) + 1];

        for (int i = 0; i < num1.length(); i++) {
            List1[i] = num1.charAt(i) - '0';
        }

        for (int i = 0; i < num2.length(); i++) {
            List2[i] = num2.charAt(i) - '0';
        }

        sb.append(Arrays.toString(List1) + "\n");
        sb.append(Arrays.toString(List2));

        System.out.println(sb);
        br.close(); 
    }
}
