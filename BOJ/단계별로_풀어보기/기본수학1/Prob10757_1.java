package BOJ.단계별로_풀어보기.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 큰 수 A + B 248ms 17236KB

public class Prob10757_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        BigInteger BigNum1 = new BigInteger(str.nextToken());
        BigInteger BigNum2 = new BigInteger(str.nextToken());

        sb.append(BigNum1.add(BigNum2));

        System.out.println(sb);
        br.close();
    }
}