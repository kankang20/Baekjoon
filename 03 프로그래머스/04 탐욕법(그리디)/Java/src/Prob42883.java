
/**
* title  : 42883. 큰 수 만들기 (Level 2)
*/

import java.util.*;

public class Prob42883 {
    
    public static void main(String[] args) {

        String n1 = "1924";
        int k1 = 2;
        System.out.println(solution(n1, k1));

        String n2 = "1231234";
        int k2 = 3;
        System.out.println(solution(n2, k2));

        String n3 = "4177252841";
        int k3 = 4;
        System.out.println(solution(n3, k3));
    }

    public static String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();

        for (char temp : number.toCharArray()) {

            while (!stack.isEmpty() && stack.peek() < temp && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(temp);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }
        
        String answer = "";
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }
}
