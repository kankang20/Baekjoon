
/**
* title  : 43162. 네트워크 (Level 3)
*/

import java.util.*;

public class Prob43162 {
    
    static boolean[] selected;
    
    public static void main(String[] args) {

        int n1 = 3;
        int[][] c1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n1, c1));

        int n2 = 3;
        int[][] c2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n2, c2));
    }

    public static int solution(int n, int[][] computers) {

        selected = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!selected[i]) {
                answer += 1;
                bfs(n, computers, i);
            }
        }

        return answer;
    }

    public static void bfs(int n, int[][] computers, int start) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        selected[start] = true;

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int i = 0; i < n; i++) {
                if (!selected[i] && computers[now][i] == 1) {
                    q.add(i);
                    selected[i] = true;
                }
            }
        }
    }
}
