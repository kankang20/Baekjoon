package PROGRAMMERS.스택큐;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {

    public static void main(String[] args) {

        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses1, speeds1)));

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses2, speeds2)));

    }

    public static int[] solution(int[] progresses, int[] speeds) {

        int length = progresses.length;

        int[] diff = new int[length];

        // 각 기능이 어느 정도의 시간이 필요한가
        for (int i = 0; i < length; i++) {
            int temp = 100 - progresses[i];
            diff[i] = temp / speeds[i] + (temp % speeds[i] > 0 ? 1 : 0);
        }

        int count = 0, previous = diff[0];

        List<Integer> answer = new ArrayList<>();

        for (int number : diff) {
            if(number <= previous) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                previous = number;
            }
        }

        answer.add(count);
        return answer.stream().mapToInt(i -> i).toArray();
    } // end solution
}
