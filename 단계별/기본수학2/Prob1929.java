package 단계별.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Prob1929 {
    public static void main(String[] args) throws IOException {
       
        // 에라토스테네스의 체로 구현

        // OPTION 1 : 376ms 27180KB

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());

        ArrayList<Boolean> primeList = new ArrayList<>(N + 1);

        primeList.add(false);
        primeList.add(false);

        for (int i = 2; i <= N; i++) {
            primeList.add(i, true);
        }

        for (int i = 2; (i*i) <= N; i++) {
            if (primeList.get(i)) {
                for (int j = i*i; j <= N; j+=i) primeList.set(j, false);
            }
        }

        for (int i = M; i <= N; i++) {
            if (primeList.get(i)) {
                sb.append(i + "\n");
            }
        }

        // OPTION 3 : 328ms 24436KB

        boolean[] check = new boolean[N+1];

        check[0] = true;
        check[1] = true;

        for (int i = 2; i <= Math.sqrt(N+1); i++) {

            if (check[i]) continue;

            for (int j = i*i; j <= N; j += i) {
                check[j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!check[i]) sb.append(i + "\n");
        }
        
        System.out.println(sb);
        br.close(); 
    }
}
