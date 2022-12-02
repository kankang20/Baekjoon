package BOJ.단계별로_풀어보기.반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 더하기 사이클 128ms 14324KB

public class Prob1110_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int default_number = Integer.parseInt(br.readLine());

        int number = default_number % 10 * 10 + ((default_number / 10 + default_number % 10)) % 10;
        int check = 1;

        while (number != default_number) {

            number = number % 10 * 10 + ((number / 10 + number % 10)) % 10;

            check++;
        }

        bw.write(Integer.toString(check));

        bw.flush();

        bw.close();
        br.close();
    }
}