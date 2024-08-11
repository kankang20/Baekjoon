import java.util.Arrays;

/**
* title  : 42747. H-Index (Level 2)
*/

public class Prob42747 {
    
    public static void main(String[] args) {

        int[] c1 = {3, 0, 6, 1, 5};
        System.out.println(solution(c1));

        int[] c2 = {3, 0, 6, 1, 5, 8};
        System.out.println(solution(c2));

        int[] c3 = {6, 5, 5, 5, 3, 2, 1, 0};
        System.out.println(solution(c3));

        int[] c4 = {0, 0, 0, 0, 0};
        System.out.println(solution(c4));
    }

    public static int solution(int[] citations) {

        Arrays.sort(citations);

        int length = citations.length;
        for (int i = 0; i < length; i++) {

            int count = length - i;

            if (count <= citations[i]) {
                return count;
            }
        }

        return 0;
    }
}
