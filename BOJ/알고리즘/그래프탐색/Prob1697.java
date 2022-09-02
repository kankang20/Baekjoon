package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 160ms 16100KB
// 그래프 이론, 그래프 탐색, 너비우선 탐색

public class Prob1697 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (start == end)
            sb.append(0);
        else
            SeekAndHide(start, end);

        System.out.println(sb);
    }

    private static void SeekAndHide(int start, int end) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        boolean[] visited = new boolean[100001];
        visited[start] = true;

        int count = 0;
        int size = 0;

        while (true) {
            count++;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                int middle = queue.poll();
                if (middle - 1 == end || middle + 1 == end || middle * 2 == end) {
                    sb.append(count);
                    return;
                }
                if (middle - 1 >= 0 && !visited[middle - 1]) {
                    visited[middle - 1] = true;
                    queue.offer(middle - 1);
                }
                if (middle + 1 <= 100000 && !visited[middle + 1]) {
                    visited[middle + 1] = true;
                    queue.offer(middle + 1);
                }
                if (middle * 2 <= 100000 && !visited[middle * 2]) {
                    visited[middle * 2] = true;
                    queue.offer(middle * 2);
                }
            }
        }
    }
}
