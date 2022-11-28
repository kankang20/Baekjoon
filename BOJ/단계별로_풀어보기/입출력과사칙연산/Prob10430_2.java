package BOJ.단계별로_풀어보기.입출력과사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나머지 128ms 14232KB

public class Prob10430_2 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str, " ");

        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());
        int C2 = Integer.parseInt(st.nextToken());

        System.out.println((A2 + B2) % C2);
        System.out.println(((A2 % C2) + (B2 % C2)) % C2);
        System.out.println((A2 * B2) % C2);
        System.out.println(((A2 % C2) * (B2 % C2)) % C2);
    }
}
