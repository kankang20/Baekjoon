package PROGRAMMERS.코딩테스트_고득점_Kit.힙;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {

    public static void main(String[] args) {

        int[][] jobs = {{0, 3}, {2, 6}, {1, 9}};

        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {

        // 요청 시점에 따라 정렬 : 오름차순
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        // 소요 시간에 따라 정렬 : 오름차순
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int time = 0, answer = 0;
        int idx = 0, count = 0, allCount = jobs.length;

        while(count < allCount) {

            while(idx < allCount && jobs[idx][0] <= time) {
                heap.add(jobs[idx++]);
            }

            if(heap.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] temp = heap.poll();
                time += temp[1];
                answer += (time - temp[0]);
                count++;
            }
        }

        return answer/allCount;
    } // end solution
}
