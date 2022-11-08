package BOJ.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 캐슬 디펜스 448ms 25988KB (java11) 388ms 20736KB (java8)
// 구현, 그래프 이론, 브루트포스 알고리즘, 시뮬레이션

public class Prob17135 {

    private static int R, C, D, ans; // 행, 열, 궁수의 공격거리 제한, 화살을 맞은 적의 최대 수

    private static List<enemy> enemies = new ArrayList<>(); // 적들의 위치 저장

    private static int[] arrows = new int[3]; // 궁수들의 위치 저장

    private static class enemy {
        int i, j; // 적의 좌표
        boolean isDead, isArrowed; // 적이 살아있나?, 화살을 맞아서 죽었나?

        public enemy(int i, int j, boolean isDead, boolean isArrowed) {
            this.i = i;
            this.j = j;
            this.isDead = isDead;
            this.isArrowed = isArrowed;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 ////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    enemies.add(new enemy(i, j, false, false));
                }
            }
        }

        // 실행 ////////////////////////////////////////////////////

        // 궁수 자리 뽑기
        // 게임 진행해서 화살로 제거 가능한 최대 적 개수 구하기 -> 갱신

        game_start(0, 0);

        sb.append(ans);
        System.out.println(sb);

    } // end main

    private static void game_start(int cnt, int start) {

        if (cnt == 3) { // 궁수 자리 다 뽑으면

            List<enemy> temp_enemies = new ArrayList<>(); // 적 리스트 복사

            for (int i = 0, end = enemies.size(); i < end; i++) {
                enemy e = enemies.get(i);
                temp_enemies.add(new enemy(e.i, e.j, e.isDead, e.isArrowed));
            }

            while (true) {

                int[] what_enemy = new int[3]; // 궁수가 공격할 적의 인덱스 저장

                for (int i = 0; i < 3; i++) {
                    what_enemy[i] = -1;
                }

                // 1. 궁수가 공격
                for (int i = 0; i < 3; i++) {

                    int dis = D;
                    int c = C;

                    for (int j = 0, end = temp_enemies.size(); j < end; j++) {

                        enemy temp = temp_enemies.get(j);

                        if (!temp.isDead) { // 아직 죽지 않았고,

                            int diff = cal_distance(R, arrows[i], temp.i, temp.j);

                            // 거리가 이미 측정한 거리보다 작거나, 거리는 같아도 더 왼쪽에 위치하거나
                            if ((diff < dis) || (diff == dis && temp.j < c)) {
                                dis = diff;
                                c = temp.j;
                                what_enemy[i] = j;
                            }
                        }
                    }
                }

                // 공격이 끝나면 적의 상태 변경
                for (int i = 0; i < 3; i++) {

                    if (what_enemy[i] == -1)
                        continue;

                    temp_enemies.get(what_enemy[i]).isDead = true;
                    temp_enemies.get(what_enemy[i]).isArrowed = true;
                }

                // 2. 적이 이동
                for (int i = 0, end = temp_enemies.size(); i < end; i++) {

                    temp_enemies.get(i).i++;

                    if (temp_enemies.get(i).i == R)
                        temp_enemies.get(i).isDead = true;
                }

                // 남아있는 적의 개수 계산하기
                int count = 0;

                for (enemy e : temp_enemies) {
                    if (!e.isDead)
                        count++;
                }

                if (count == 0)
                    break;
            }

            // 3. 화살 맞은 적의 개수 계산

            int max = 0;

            for (enemy e : temp_enemies) {
                if (e.isArrowed)
                    max++;
            }

            // 정답 갱신
            ans = Math.max(ans, max);

            return;
        }

        for (int i = start; i < C; i++) {
            arrows[cnt] = i;
            game_start(cnt + 1, i + 1);
        }

    } // end game_start

    private static int cal_distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
