package BOJ.단계별로_풀어보기.배열1차원;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최소, 최대 1400ms 102748KB

public class Prob10818_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] IntArray = new int[count];

        for (int i = 0; i < count; i++) {
            IntArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(IntArray);

        bw.write(Integer.toString(IntArray[0]) + " " + Integer.toString(IntArray[count - 1]));

        bw.flush();

        bw.close();
        br.close();
    }
}