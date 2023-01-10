package BOJ.알고리즘.최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 네트워크 연결 596ms 48500KB (java11) 468ms 45528KB (java8)
// 그래프 이론, 최소 스패닝 트리 kruskal

public class Prob1922_1 {

    static int N, M; // 컴퓨터의 수, 선의 수

    static int[] parents;
    static edge[] edges;

    static class edge implements Comparable<edge> {
        int from, to, weight;

        public edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(edge o) {
            return this.weight - o.weight;
        }
    }

    static void make() {
        parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if (parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot)
            return false;

        parents[bRoot] = aRoot;
        return true;

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 기본 입력

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new edge[M];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i] = new edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        // 실행

        make();

        Arrays.sort(edges);

        int result = 0, count = 0;
        for (edge e : edges) {
            if (union(e.from, e.to)) {
                result += e.weight;
                if (++count == N - 1)
                    break;
            }
        }

        // 결과

        sb.append(result);
        System.out.println(sb);
    }
}
