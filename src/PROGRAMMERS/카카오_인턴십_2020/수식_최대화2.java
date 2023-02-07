package PROGRAMMERS.카카오_인턴십_2020;

import java.util.Arrays;

public class 수식_최대화2 {

    public static void main(String[] args) {

        String string1 = "100-200*300-500+20";
        System.out.println(solution(string1));

        String string2 = "50*6-3*2";
//        System.out.println(solution(string2));
    }

    private static final String[] operation = {"\\+", "\\-", "\\*"};
    private static int[] selected;
    private static long answer;
    private static String express;

    public static long solution(String expression) {

        selected = new int[3];

        express = expression;
        answer = 0;

        check(0, 0);

        return answer;
    }

    private static void check(int cnt, int start) {

        if (cnt == 3) {
            System.out.println(Arrays.toString(selected));
            answer = Math.max(answer, Math.abs(recursive(express, selected, 0)));
            return;
        }

        for (int i = start; i < 3; i++) {
            selected[cnt] = i;
            check(cnt+1, i+1);
        }
    }

    private static Long recursive(String expression, int[] selected, int cnt) {

        String[] list = expression.split(operation[selected[cnt]]);

        long previous = 0, now = 0;

        for (int i = 0, end = list.length; i < end; i++) {

            if(isNumber(list[i])) {
                now = Long.parseLong(list[i]);
            } else {
                now = recursive(list[i], selected, cnt + 1);
            }

            System.out.println(now);

            if(i == 0) previous = now;
            else previous = calculate(previous, now, operation[selected[cnt]]);
        }
        return previous;
    }

    private static long calculate(long previous, long now, String s) {
        if(s.equals("\\*"))  return previous * now;
        else if (s.equals("\\+")) return previous + now;
        else return previous - now;
    }

    private static boolean isNumber(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

} // end class
