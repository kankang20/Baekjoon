
/**
* title  : 1916. 최소비용 구하기 (Gold 5)
* time   : 568ms
* memory : 51424KB
*/

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {

    int target;
    int cost;

    Edge(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Prob1916 {
    
    static int N, M;
    static ArrayList<ArrayList<Edge>> edges;
    static boolean[] selected;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 도시의 개수
        int M = Integer.parseInt(br.readLine());    // 버스의 개수

        edges = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            edges.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.get(start).add(new Edge(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startEdge = Integer.parseInt(st.nextToken());
        int endEdge = Integer.parseInt(st.nextToken());

        selected = new boolean[N+1];
        distance = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        System.out.println(dijkstra(startEdge, endEdge));
    }

    public static int dijkstra(int startEdge, int endEdge) {

        PriorityQueue<Edge> q = new PriorityQueue<>();

        q.add(new Edge(startEdge, 0));
        distance[startEdge] = 0;

        while (!q.isEmpty()) {

            Edge nowEdge = q.poll();

            if (!selected[nowEdge.target]) {
                selected[nowEdge.target] = true;
                for (Edge nextEdge : edges.get(nowEdge.target)) {
                    if (!selected[nextEdge.target] && distance[nowEdge.target] + nextEdge.cost < distance[nextEdge.target]) {
                        distance[nextEdge.target] = distance[nowEdge.target] + nextEdge.cost;
                        q.add(new Edge(nextEdge.target, distance[nextEdge.target]));
                    }
                }
            }
        }

        return distance[endEdge];
    }
}
