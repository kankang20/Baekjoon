package BOJ.알고리즘2.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Silver 5. 카약과 강풍

public class Prob2891 {

    private static int N, S, R; // 팀의 수, 카약이 손상된 팀의 수, 카약을 하나 더 가져온 팀의 수
    private static int[] team;
    private static int ans;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 팀의 수
        S = Integer.parseInt(st.nextToken());   // 카약이 손상된 팀의 수
        R = Integer.parseInt(st.nextToken());   // 카약을 하나 더 가져온 팀의 수

        team = new int[N];

        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            team[i] = 1;    // default는 1
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            team[Integer.parseInt(st.nextToken())-1] -= 1;     // 카약이 손상되면 0
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            team[Integer.parseInt(st.nextToken())-1] += 1;     // 카약이 준비되어 있으면 2
        }

        wind(0);

        sb.append(ans);
        System.out.println(sb);

    } // end main

    private static void wind(int cnt) {

        if (cnt == N) { // 출발할 수 없는 팀 개수 구하기 -> 최소값 갱신
            int count = 0;

            for (int t : team) {
                if(t == 0) count++;
            }

            ans = Math.min(count, ans);
            return;
        }

        // 카약 빌려주기
        // 1. 카약을 하나 더 가져온 팀에 대해서만 재귀가 실행됨
        if(team[cnt] == 2) {

            // 2. 카약을 줄 수 있는 팀을 탐색해서 재귀
            if(cnt == 0) {              // 2-1. 0인 경우에는 1만 생각
                if(team[1] == 0) {
                    team[0]--;
                    team[1]++;
                    wind(1);
                    team[0]++;
                    team[1]--;
                }

                wind(1);

            } else if (cnt == N-1) {    // 2-2. N-1인 경우에는 N-2만 생각
                if(team[cnt-1] == 0) {
                    team[cnt]--;
                    team[cnt-1]++;
                    wind(cnt+1);
                    team[cnt]++;
                    team[cnt-1]--;
                }

                wind(cnt+1);
            } else {                    // 2-3. 이외 좌우 탐색
                if(team[cnt-1] == 0) {
                    team[cnt]--;
                    team[cnt-1]++;
                    wind(cnt+1);
                    team[cnt]++;
                    team[cnt-1]--;
                }

                if(team[cnt+1] == 0) {
                    team[cnt]--;
                    team[cnt+1]++;
                    wind(cnt+1);
                    team[cnt]++;
                    team[cnt+1]--;
                }

                wind(cnt+1);
            }
        } else {
            wind(cnt+1);
        }
    } // end wind
}
