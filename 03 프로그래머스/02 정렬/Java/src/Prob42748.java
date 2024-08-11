
/**
* title  : 42748. K번째수 (Level 1)
*/

import java.util.*;

public class Prob42748 {
    
    public static void main(String[] args) {

        int[] a1 = {1, 5, 2, 6, 3, 7, 4};
        int[][] c1 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(a1, c1)));
    } 

    public static int[] solution(int[] array, int[][] commands) {

        List<Integer> answer = new ArrayList<>();
        for (int[] comm : commands) {

            List<Integer> temp = new ArrayList<>();
            for (int i = comm[0]-1; i < comm[1]; i++) {
                temp.add(array[i]);
            }

            temp.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });

            answer.add(temp.get(comm[2]-1));
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
