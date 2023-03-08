package PROGRAMMERS.정렬;

import java.util.*;

public class K번째수 {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array, commands)));
    } // end main

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int i = 0, end = commands.length; i < end; i++) {

            List<Integer> list = new ArrayList<>();

            for (int j = commands[i][0]-1, end2 = commands[i][1]; j < end2; j++) {
                list.add(array[j]);
            }

            Collections.sort(list);
            answer[i] = list.get(commands[i][2] - 1);
        }
        return answer;
    } // end solution
}
