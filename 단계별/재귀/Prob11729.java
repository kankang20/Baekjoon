package 단계별.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob11729 {

    // OPTION 1 : 508ms 70868KB
    // https://ko.wikipedia.org/wiki/%ED%95%98%EB%85%B8%EC%9D%B4%EC%9D%98_%ED%83%91

    public static StringBuilder sb = new StringBuilder();

    public static void recursive (int num, int from, int by, int to) {

        if (num == 1) {
            sb.append(from + " " + to + "\n"); 
        } else {
            recursive(num-1, from, to, by);
            sb.append(from + " " + to + "\n");
            recursive(num-1, by, from, to);
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        // 원판 이동 횟수
        sb.append((int)Math.pow(2, number) - 1 + "\n");

        // 원판 이동 경로
        recursive(number, 1, 2, 3);

        System.out.println(sb);
        br.close(); 
    }
    
}
