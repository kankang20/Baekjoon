package BOJ.단계별로_풀어보기.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 주사위 세개 124ms 14344KB

public class Prob2480_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String a = st.nextToken();
        String b = st.nextToken();
        String c = st.nextToken();

        int anum = Integer.parseInt(a);
        int bnum = Integer.parseInt(b);
        int cnum = Integer.parseInt(c);

        int sum = 0;

        if (a.equals(b) && b.equals(c)) {
            sum = 10000 + anum * 1000;
        } else if (a.equals(b) || a.equals(c)) {
            sum = 1000 + anum * 100;
        } else if (b.equals(c)) {
            sum = 1000 + cnum * 100;
        } else {
            sum = Math.max(Math.max(anum, bnum), cnum) * 100;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();

        br.close();

    }
}
