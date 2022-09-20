package BOJ.알고리즘.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사촌 1344ms 213520KB (java11) 900ms 213076KB (java8)
// 자료구조, 트리

public class Prob9489 {

    static class node {
        int num, parent, plevel; // 본인 노드, 부모 노드, 부모 노드 레벨

        public node(int num, int parent, int plevel) {
            this.num = num;
            this.parent = parent;
            this.plevel = plevel;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        StringTokenizer st;

        while (true) {
            sb = new StringBuilder();

            // 기본 입력
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 노드 수
            int K = Integer.parseInt(st.nextToken()); // 사촌의 수를 구해야 하는 노드 번호

            int kidx = 0; // 사촌을 구해야하는 노드 번호의 인덱스

            if (N == 0 && K == 0)
                break;

            node[] nodes = new node[N];

            int num = 0, parent = 0, plevel = 0; // 본인의 노드, 본인의 부모 노드, 본인의 부모 레벨
            int idx_parent = 0; // 본인의 부모 노드 인덱스

            st = new StringTokenizer(br.readLine());

            // 첫번째 노드 받기
            num = Integer.parseInt(st.nextToken());
            nodes[0] = new node(num, -1, plevel); // 루트

            // 그 다음 노드 받기
            for (int i = 1; i < N; i++) {
                num = Integer.parseInt(st.nextToken());

                if (num == K)
                    kidx = i;

                // 부모 /////////////////////////

                if (num != nodes[i - 1].num + 1)
                    parent = nodes[idx_parent++].num;

                if (idx_parent == -1)
                    parent = -1;

                // 부모 레벨 ////////////////////

                if (parent == -1)
                    plevel = 0;
                else if (nodes[i - 1].parent + 1 < parent)
                    plevel++;

                ////////////////////////////////

                nodes[i] = new node(num, parent, plevel);

            }

            // 실행 - 사촌 찾기

            int ans = 0;

            int kplevel = nodes[kidx].plevel, kparent = nodes[kidx].parent;

            for (node no : nodes) {
                if (no.plevel == kplevel && kparent != no.parent)
                    ans++;
            }

            sb.append(ans);
            System.out.println(sb);
        }
    }
}
