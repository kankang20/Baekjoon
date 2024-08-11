
/**
* title  : 42627. 디스크 컨트롤러 (Level 3)
*/

import java.util.*;

public class Prob42627 {
    
    public static void main(String[] args) {

        int[][] j1 = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(j1));
    }

    public static int solution(int[][] jobs) {

        // 시간대로 나오되 그 시간 안에 가능한 모든 디스크 가져와서 비교하기
        // [작업이 요청되는 시점, 작업의 소요시간]

        // Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->o1[1] - o2[1]);

        Arrays.sort(jobs, Comparator.comparing((o)->o[0]));
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing((o)->o[1]));

        int job_length = jobs.length;
        int jdx = 0;            

        int time = 0;
        int count = 0;
        
        int answer = 0;
        while (count < job_length){

            // 지금 시점에서 들어와 있는 디스크 찾기
            while (jdx < job_length && jobs[jdx][0] <= time) {
                q.add(jobs[jdx++]);
            }
                
            if (q.isEmpty()) {
                time = jobs[jdx][0];
            } else {                        // 소요 시간이 가장 짧은거 하나 가져오기
                int[] disk = q.poll();
                time += disk[1];
                answer += (time - disk[0]);
                count += 1;
            }
        }

        return answer/job_length;
    }
}
