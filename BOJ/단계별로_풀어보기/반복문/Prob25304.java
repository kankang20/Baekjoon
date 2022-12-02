package BOJ.단계별로_풀어보기.반복문;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 영수증 124ms 14096Kb (java11) 76ms 11624KB (java8)

public class Prob25304 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int totalPrice = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            totalPrice -= Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        sb.append(totalPrice == 0 ? "Yes" : "No");
        System.out.println(sb);
    }

}
