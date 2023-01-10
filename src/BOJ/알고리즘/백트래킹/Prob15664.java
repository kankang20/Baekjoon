package BOJ.알고리즘.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (10) 164ms 16348KB
// 백트래킹

public class Prob15664 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> list = new ArrayList<>(); // linkedhashset

    static int N, M; // N개 중에서 M개 뽑기
    static int[] input; // input 자연수
    static int[] answer; // 선택

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 기본 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 실행
        Arrays.sort(input); // 오름차순
        search(0, 0);

        // 출력
        for (int i = 0, end = list.size(); i < end; i++) {
            if (i == end - 1)
                sb.append(list.get(i));
            else
                sb.append(list.get(i) + "\n");
        }
        System.out.println(sb);

    }

    static void search(int cnt, int start) {

        if (cnt == M) {

            String s = "";
            for (int i = 0; i < M; i++) {
                s += answer[i] + " ";
            }

            if (!list.contains(s))
                list.add(s);

            return;
        }

        for (int i = start; i < N; i++) {
            answer[cnt] = input[i];
            search(cnt + 1, i + 1);
        }
    }
}
