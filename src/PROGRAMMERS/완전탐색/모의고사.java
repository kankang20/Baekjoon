package PROGRAMMERS.완전탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

    public static void main(String[] args) {

        int[] answers1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(answers1)));

        int[] answers2 = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers2)));
    }

    public static int[] solution(int[] answers) {

        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int p1 = person1.length, p2 = person2.length, p3 = person3.length;
        int count1 = 0, count2 = 0, count3 = 0;

        for (int i = 0, end = answers.length; i < end; i++) {
            int answer = answers[i];
            if(answer == person1[i%p1]) count1++;
            if(answer == person2[i%p2]) count2++;
            if(answer == person3[i%p3]) count3++;
        }

        int maxCount = Math.max(count1, Math.max(count2, count3));

        List<Integer> list = new ArrayList<>();

        if(count1 >= maxCount) list.add(1);
        if(count2 >= maxCount) list.add(2);
        if(count3 >= maxCount) list.add(3);

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);

        return answer;
    }
}
