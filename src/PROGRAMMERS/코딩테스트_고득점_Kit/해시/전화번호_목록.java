package PROGRAMMERS.코딩테스트_고득점_Kit.해시;

import java.util.Arrays;

public class 전화번호_목록 {

    public static void main(String[] args) {

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book1));

        String[] phone_book2 = {"123","456","789"};
        System.out.println(solution(phone_book2));

        String[] phone_book3 = {"12","123","1235","567","88"};
        System.out.println(solution(phone_book3));

    }

    public static boolean solution(String[] phone_book) {

        int size = phone_book.length, preLength = 0, nextLength = 0;
        Arrays.sort(phone_book);

        // "효율성 테스트"에 통과하려면 for 문을 한번만 실행해야 함
        for (int i = 0; i < size-1; i++) {

            preLength = phone_book[i].length();
            nextLength = phone_book[i+1].length();

            if(preLength < nextLength) {
                if(phone_book[i].equals(phone_book[i+1].substring(0, preLength))) return false;
            } else if (preLength > nextLength) {
                if(phone_book[i+1].equals(phone_book[i].substring(0, nextLength))) return false;
            } else {
                if(phone_book[i].equals(phone_book[i+1])) return false;
            }
        }
        return true;
    } // end solution
}
