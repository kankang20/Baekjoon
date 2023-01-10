package BOJ.단계별로_풀어보기.입출력과사칙연산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1998년생인 내가 태국에서는 2541년생?!
// 136ms 14252KB

public class Prob18108_3 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int a = Integer.parseInt(str);

        bw.write(Integer.toString(a - 543));
        bw.flush();
        bw.close();

        br.close();
    }
}
