package BOJ.알고리즘.우선순위큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 문제 추천 시스템 Version 1
// 자료구조, 트리를 사용한 집합과 맵, 우선순위 큐

// FIX 시간 초과

public class Prob21939 {

    private static List<problem> pros = new ArrayList<>(); // 문제들
    private static StringBuilder sb = new StringBuilder();

    private static class problem implements Comparable<problem> {
        int P, L; // 문제 번호, 난이도

        public problem(int P, int L) {
            this.P = P;
            this.L = L;
        }

        @Override
        public int compareTo(problem o) {
            int check = this.L - o.L;
            if (check == 0)
                check = this.P - o.P;
            return check;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 //////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine()); // 문제 개수

        for (int i = 0; i < N; i++) { // 문제 번호 + 난이도 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            pros.add(new problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int M = Integer.parseInt(br.readLine()); // 명령문의 개수

        // 실행 //////////////////////////////////////////////////////////

        for (int i = 0; i < M; i++) {
            command(br.readLine());

        }

        System.out.println(sb);
    }

    private static void command(String line) {

        StringTokenizer st = new StringTokenizer(line);

        switch (st.nextToken()) {

            case "recommend":
                recommend(Integer.parseInt(st.nextToken()));
                break;
            case "add":
                add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                break;
            case "solved":
                solved(Integer.parseInt(st.nextToken()));
                break;
        }
    }

    private static void solved(int p) {
        for (int i = 0, end = pros.size(); i < end; i++) {
            if (pros.get(i).P == p) {
                pros.remove(i);
                break;
            }
        }
    } // end solved

    private static void add(int p, int l) {
        pros.add(new problem(p, l));
    } // end add

    private static void recommend(int x) {

        pros.sort(null);
        problem pro = null;

        if (x == 1) {
            pro = pros.remove(pros.size() - 1);
        } else if (x == -1) {
            pro = pros.remove(0);
        }

        sb.append(pro.P + "\n");
    } // end recommend
}
