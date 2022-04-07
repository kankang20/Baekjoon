package 단계별.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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

        // OPTION 2 : 140ms 14584KB

        String num1 = str.nextToken();
        String num2 = str.nextToken();

        int max = Math.max(num1.length(), num2.length());

        int[] List1 = new int[max+1];
        int[] List2 = new int[max+1];

        for (int i = num1.length() - 1, idx = 0; i >= 0; i--, idx++) {
            List1[idx] = num1.charAt(i) - '0';
        }

        for (int i = num2.length() - 1, idx = 0; i >= 0; i--, idx++) {
            List2[idx] = num2.charAt(i) - '0';
        }

        for (int i = 0; i < max; i++) {
            int sum = List1[i] + List2[i];

            List1[i+1] += sum / 10;
            List1[i] = sum % 10;
        }

        if (List1[max] != 0) {
            sb.append(List1[max]);
        }

        for (int i = max-1; i >= 0; i--) {
            sb.append(List1[i]);
        }
        
        System.out.println(sb);
        br.close(); 
    }
}
