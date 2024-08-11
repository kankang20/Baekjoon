
/**
* title  : 42862. 체육복 (Level 1)
*/

public class Prob42862 {
    
    public static void main(String[] args) {

        int n1 = 5;
        int[] l1 = {2, 4};
        int[] r1 = {1, 3, 5};
        System.out.println(solution(n1, l1, r1));

        int n2 = 5;
        int[] l2 = {2, 4};
        int[] r2 = {3};
        System.out.println(solution(n2, l2, r2));

        int n3 = 3;
        int[] l3 = {3};
        int[] r3 = {1};
        System.out.println(solution(n3, l3, r3));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        
        int[] student = new int[n];

        for (int l : lost) {
            student[l-1] -= 1;
        }

        for (int r : reserve) {
            student[r-1] += 1;
        }

        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (student[i] >= 0) continue;

            temp = i-1;
            if (0 <= temp && 0 < student[temp]) {
                student[temp] -= 1;
                student[i] += 1;
                continue;
            }

            temp = i+1;
            if (temp < n && 0 < student[temp]) {
                student[temp] -= 1;
                student[i] += 1;
                continue;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (0 <= student[i]) {
                answer += 1;
            }
        }
        
        return answer;
    }
}
