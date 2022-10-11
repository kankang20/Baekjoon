package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 원자 소멸 시뮬레이션 2248ms 278684KB

public class Prob5648 {

    private static class atom {
        int x, y, dir, k;

        public atom(int x, int y, int dir, int k) {
            this.x = x; // x 위치
            this.y = y; // y 위치
            this.dir = dir; // 이동 방향
            this.k = k; // 보유 에너지
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 //////////////////////////////////////////////////////////////////

            int N = Integer.parseInt(br.readLine()); // 원자들의 수
            List<atom> atoms = new ArrayList<>(N); // 살아있는 원자들 저장

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                atoms.add(new atom((Integer.parseInt(st.nextToken()) + 1000) * 2, // x
                        (Integer.parseInt(st.nextToken()) + 1000) * 2, // y
                        Integer.parseInt(st.nextToken()), // dir
                        Integer.parseInt(st.nextToken()))); // k
            } // 0 ~ 4000으로 좌표 이동

            // 실행 //////////////////////////////////////////////////////////////////

            sb.append("#" + testcase + " " + move_bomb(atoms));
            System.out.println(sb);
        }
    }

    private static int move_bomb(List<atom> atoms) {

        int allEnergy = 0; // 총 에너지

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { 1, -1, 0, 0 };

        int[][] map = new int[4001][4001]; // 원자의 이동상황 파악

        while (!atoms.isEmpty()) {

            // 원자들 이동하자
            for (int a = 0; a < atoms.size(); a++) {

                atom now = atoms.get(a);

                map[now.x][now.y] = 0; // 출발

                now.x += dx[now.dir];
                now.y += dy[now.dir];

                if (now.x < 0 || now.x > 4000 || now.y < 0 || now.y > 4000) {
                    atoms.remove(a);
                    a--;
                    continue;
                }

                map[now.x][now.y] += now.k;
            }

            // 원자들 소멸하자
            for (int a = 0; a < atoms.size(); a++) {

                atom now = atoms.get(a);

                if (map[now.x][now.y] != now.k) {
                    allEnergy += map[now.x][now.y]; // 에너지 방출
                    map[now.x][now.y] = 0; // 에너지 소멸
                    atoms.remove(a); // 충돌했으니 원자도 소멸
                    a--;
                }
            }

        }

        return allEnergy;
    }

}
