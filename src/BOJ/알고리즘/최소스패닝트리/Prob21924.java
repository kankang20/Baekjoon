package BOJ.알고리즘.최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 도시 건설 1856ms 174840KB (java11) 1772ms 180560KB (java8)
// 그래프 이론, 최소 스패닝 트리

// FIX 시간을 줄이는 방법

public class Prob21924 {
    static int N, M; // 건물의 개수, 도로의 개수

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 건물의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수

        edges = new edge[M];
        long total = 0; // 모든 도로를 건설했을 경우의 비용

        int from, to, weight;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            edges[i] = new edge(from, to, weight);
            total += weight;
        }

        // 실행

        make();

        Arrays.sort(edges);

        long result = 0, count = 0;
        boolean check = false;

        for (edge e : edges) {
            if (union(e.from, e.to)) {
                result += e.weight;
                if (++count == N - 1) {
                    check = true;
                    break;
                }
            }
        }

        // 결과

        if (check)
            sb.append(total - result);
        else
            sb.append(-1);

        System.out.println(sb);
    }
}
