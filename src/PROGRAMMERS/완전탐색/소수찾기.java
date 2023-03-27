package PROGRAMMERS.완전탐색;

import java.util.ArrayList;
import java.util.List;

public class 소수찾기 {

    public static void main(String[] args) {

        String numbers1 = "17";
        System.out.println(solution(numbers1));

        String numbers2 = "011";
        System.out.println(solution(numbers2));

    }

    private static int allSize;
    private static String allNumbers;
    private static boolean[] selected;
    private static List<Integer> list;

    public static int solution(String numbers) {

        allSize = numbers.length();
        allNumbers = numbers;

        list = new ArrayList<>();
        selected = new boolean[allSize];

        for (int i = 0; i < allSize; i++) {
            recursive(0, "");
        }

        int answer = 0;

        for (int number : list) {
            if(isPrime(number)) answer++;
        }

        return answer;
    }

    public static void recursive(int cnt, String choose) {

        if(!choose.equals("")) {
            int temp = Integer.parseInt(choose);
            if(!list.contains(temp)) list.add(temp);
        }

        if(cnt == allSize) return;

        for (int i = 0; i < allSize; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            recursive(cnt+1, choose + allNumbers.charAt(i));
            selected[i] = false;
        }
    }

    public static boolean isPrime(int number) {
        // 에라토스테네스의 체
        if(number < 2) return false;

        for (int i = 2; i*i <= number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
