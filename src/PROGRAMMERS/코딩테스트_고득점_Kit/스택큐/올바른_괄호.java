package PROGRAMMERS.코딩테스트_고득점_Kit.스택큐;

public class 올바른_괄호 {

    public static void main(String[] args) {

        String s1 = "()()";
        System.out.println(solution(s1));

        String s2 = "(())()";
        System.out.println(solution(s2));

        String s3 = ")()(";
        System.out.println(solution(s3));


        String s4 = "(()(";
        System.out.println(solution(s4));

    }

    static boolean solution(String s) {

        int check = 0;

        for (int i = 0, end = s.length(); i < end; i++) {

            char temp = s.charAt(i);

            if(temp == '(') check++;
            else {
                if(check > 0) check--;
                else return false;
            }
        }

        return check == 0;
    } // end solution
}
