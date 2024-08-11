
/**
* title  : 42839. 소수 찾기 (Level 2)
*/

import java.util.*;

public class Prob42839 {
    
    static int N;
    static Set<Integer> numberSet;
    static boolean[] selected;

    public static void main(String[] args) {

        String n1 = "17";
        System.out.println(solution(n1));

        String n2 = "011";
        System.out.println(solution(n2));
    }

    public static int solution(String numbers) {
        
        N = numbers.length();
        
        numberSet = new HashSet<>();
        selected = new boolean[N];
        
        dfs(numbers, 0, "");
        
        int answer = 0;
        for (Integer num : numberSet) {
            if (1 < num && isPrime(num)) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public static void dfs(String numbers, int count, String word) {
        
        if (count == N) {
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                numberSet.add(Integer.parseInt(word + numbers.charAt(i)));
                dfs(numbers, count+1, word + numbers.charAt(i));
                selected[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int number) {
        
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
