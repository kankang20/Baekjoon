package 단계별.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2447 {
    static char[][] star;

    public static void recursive (int x, int y, int N, boolean check) {

        if (N == 1) {
            star[x][y] = '*';
            return;
        }

        if (check) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    star[i][j] = ' ';
                }
            }
            return;
        }

        int size = N / 3;
        int count = 0;

        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;

                if(count == 5) recursive(i, j, size, true);
                else recursive(i, j, size, false);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());

        star = new char[number][number];

        recursive(0, 0, number, false);

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close(); 
    }
}

