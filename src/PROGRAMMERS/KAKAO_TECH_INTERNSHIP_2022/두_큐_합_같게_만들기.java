package PROGRAMMERS.KAKAO_TECH_INTERNSHIP_2022;

import java.util.ArrayDeque;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {

    public static void main(String[] args) {

        int[] queue11 = { 3, 2, 7, 2 };
        int[] queue12 = { 4, 6, 5, 1 };

        System.out.println(solution(queue11, queue12));

        int[] queue21 = { 1, 2, 1, 2 };
        int[] queue22 = { 1, 10, 1, 2 };

        System.out.println(solution(queue21, queue22));

        int[] queue31 = { 1, 1 };
        int[] queue32 = { 1, 5 };

        System.out.println(solution(queue31, queue32));

        // testcase

        int[] queue41 = { 1, 2 };
        int[] queue42 = { 1, 1 };

        System.out.println(solution(queue41, queue42));

        int[] queue51 = { 1, 4 };
        int[] queue52 = { 3, 4 };

        System.out.println(solution(queue51, queue52));

    }

    public static int solution(int[] queue1, int[] queue2) {

        int answer = 0;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long sum1 = 0, sum2 = 0;

        for (int i = 0, end = queue1.length; i < end; i++) {

            q1.offer(queue1[i]);
            q2.offer(queue2[i]);

            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        if ((sum1 + sum2) % 2 == 1)
            return -1;

        int temp = 0;

        // 각 배열의 길이는 최대 300,000 -> 두 배열의 길이는 동일하기 때문에 최악의 경우 이동 횟수는 600,000이 됨
        // 이 이상 넘어가면 -1
        while (answer < 600000) {

            if (sum1 < sum2) {

                temp = q2.poll();
                sum2 -= temp;

                q1.offer(temp);
                sum1 += temp;

            } else if (sum1 > sum2) {

                temp = q1.poll();
                sum1 -= temp;

                q2.offer(temp);
                sum2 += temp;

            } else
                break;

            if (sum1 == 0 || sum2 == 0)
                return -1;

            answer++;
        }

        return answer == 600000 ? -1 : answer;
    }
}
