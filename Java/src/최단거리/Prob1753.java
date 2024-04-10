package 최단거리;

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

public class Prob1753 {

    static ArrayList<ArrayList<Edge>> edges;
    static int[] distance;
    static boolean[] selected;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수

        int startEdge = Integer.parseInt(br.readLine());    // 시작 정점의 번호

        edges = new ArrayList<>();
        for (int i = 0; i < (V+1); i++) {
            edges.add(new ArrayList<>());
        }

        distance = new int[V+1];
        selected = new boolean[V+1];
        for (int i = 1; i < (V+1); i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Edge(v, w));
        }

        dijkstra(startEdge);

        for (int i = 1; i < (V+1); i++) {
            if (distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }

    public static void dijkstra(int startEdge) {

        PriorityQueue<Edge> q = new PriorityQueue<>();

        q.add(new Edge(startEdge, 0));
        distance[startEdge] = 0;

        while (!q.isEmpty()) {

            Edge cur = q.poll();

            if (!selected[cur.target]) {

                selected[cur.target] = true;

                for (Edge nex : edges.get(cur.target)) {
                    if (!selected[nex.target] && distance[nex.target] > distance[cur.target] + nex.cost) {
                        distance[nex.target] = distance[cur.target] + nex.cost;
                        q.add(new Edge(nex.target, distance[nex.target]));
                    }
                }
            }
        }
    }
}