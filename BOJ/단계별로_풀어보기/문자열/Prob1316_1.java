package BOJ.단계별로_풀어보기.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 그룹 단어 체커 156ms 16092KB

public class Prob1316_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < num; i++) {

            String text = br.readLine();

            boolean voca = true;
            String str = "";
            char previous = ' ';

            for (int j = 0; j < text.length(); j++) {

                char temp = text.charAt(j);

                if ((previous != temp) && (str.contains(String.valueOf(temp)))) {
                    voca = false;
                    break;
                }

                str += String.valueOf(temp);
                previous = temp;
            }

            if (voca == true) {
                count++;
            }

        }

        sb.append(count + "\n");

        System.out.println(sb);
        br.close();
    }
}