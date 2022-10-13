package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 샘터 556ms 227512KB (java11) 472ms 228464KB (java8)
// 자료구조, 그래프 이론, 그래프 탐색, 너비 우선 탐색

public class Prob18513 {

    private static int N, K; // 샘터의 개수, 집의 개수

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 샘터의 개수
        K = Integer.parseInt(st.nextToken()); // 집의 개수

        boolean[] plusPos = new boolean[100100001]; // 양수 위치
        boolean[] minusPos = new boolean[100100001]; // 음수 위치

        Queue<int[]> q = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            q.offer(new int[] { num, 0 });

            if (num >= 0)
                plusPos[num] = true;
            else
                minusPos[-num] = true;
        }

        sb.append(unhappiness(q, plusPos, minusPos));
        System.out.println(sb);
    }

    private static long unhappiness(Queue<int[]> q, boolean[] plusPos, boolean[] minusPos) {

        int[] d = { -1, 1 };

        long count = 0; // 집의 개수
        long sum = 0; // 불행도의 총 합

        while (!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                int[] now = q.poll();

                for (int j = 0; j < 2; j++) {

                    int next = now[0] + d[j];
                    int unhappiness = now[1] + 1;

                    if ((next < 0 && !minusPos[-next]) || (next >= 0 && !plusPos[next])) {

                        q.offer(new int[] { next, unhappiness });

                        if (next < 0)
                            minusPos[-next] = true;
                        else
                            plusPos[next] = true;

                        count++;
                        sum += unhappiness;
                    }

                    if (count == K)
                        return sum;
                }
            }
        }

        return 0;
    }

}
