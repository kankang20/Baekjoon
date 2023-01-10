package BOJ.단계별로_풀어보기.배열1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평균 128ms 14476KB

public class Prob1546_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        float max = 0;
        float sum = 0;
        float[] floatArray = new float[num];

        for (int i = 0; i < num; i++) {
            floatArray[i] = Float.parseFloat(st.nextToken());

            if (max < floatArray[i]) {
                max = floatArray[i];
            }
        }

        for (int i = 0; i < num; i++) {
            floatArray[i] = floatArray[i] / max * 100;
        }

        for (float i : floatArray) {
            sum += i;
        }

        sb.append(sum / num);

        System.out.println(sb);

        br.close();
    }
}