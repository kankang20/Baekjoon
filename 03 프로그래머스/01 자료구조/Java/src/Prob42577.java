
/**
* title  : 42577. 전화번호 목록 (Level 2)
*/

import java.util.*;

public class Prob42577 {
    
    public static void main(String[] args) {

        String[] p1 = {"119", "97674223", "1195524421"};
        System.out.println(solution(p1));

        String[] p2 = {"123","456","789"};
        System.out.println(solution(p2));

        String[] p3 = {"12","123","1235","567","88"};
        System.out.println(solution(p3));
    }
    
    public static boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i-1])) {
                return false;
            }
        }
        
        return true;
    }
}
