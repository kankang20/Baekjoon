package PROGRAMMERS.카카오_인턴십_2020;

public class 수식_최대화 {

    public static void main(String[] args) {

        String string1 = "100-200*300-500+20";
        System.out.println(solution(string1));

        String string2 = "50*6-3*2";
        System.out.println(solution(string2));
    }

    public static long solution(String expression) {

        long answer = 0;

        String[][] pro = {{"\\+", "\\-", "\\*"},
                            {"\\-", "\\+", "\\*"},
                            {"\\*", "\\+", "\\-"},
                            {"\\+", "\\*", "\\-"},
                            {"\\*", "\\-", "\\+"},
                            {"\\-", "\\*", "\\+"}};

        for (int p = 0; p < 6; p++) {
            answer = Math.max(answer, Math.abs(recursive(expression, pro[p], 0)));
        }

        return answer;
    }

    private static Long recursive(String expression, String[] calc, int cnt) {

        String[] list = expression.split(calc[cnt]);

        long previous = 0, now = 0;

        for (int i = 0, end = list.length; i < end; i++) {

            if(isNumber(list[i])) {
                now = Long.parseLong(list[i]);
            } else {
                now = recursive(list[i], calc, cnt + 1);
            }

            if(i == 0) previous = now;
            else previous = calculate(previous, now, calc[cnt]);
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
