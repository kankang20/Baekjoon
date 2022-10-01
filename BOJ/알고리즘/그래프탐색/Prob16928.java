package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀과 사다리 게임 124ms 14252KB (java11) 80ms 11696KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색

public class Prob16928 {

    private static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        map = new HashMap<>(10);

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        sb.append(search());
        System.out.println(sb);
    }

    private static int search() {

        int ans = 0; // 주사위 횟수

        boolean[] selected = new boolean[101]; // 방문 여부

        Queue<Integer> q = new ArrayDeque<>();

        // 시작
        q.offer(1);
        selected[1] = true;

        while (!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                int now = q.poll();

                // 도착
                if (now == 100)
                    return ans;

                for (int j = 1; j <= 6; j++) { // 주사위는 1부터 6

                    int move = now + j; // 이동

                    if (move > 100)
                        break;

                    // 뱀과 사다리를 타고 이동
                    if (map.containsKey(move)) {
                        move = map.get(move);
                    }

                    // 이미 방문한 적이 있으면 진행 x
                    if (selected[move])
                        continue;

                    q.offer(move);
                    selected[move] = true;
                }
            }
            ans++;
        }

        return ans;
    }
}
