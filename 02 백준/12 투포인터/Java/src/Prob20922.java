
/**
 * title  : 20922. 겹치는 건 싫어 (Silver 1)
 * time   : 364ms
 * memory :  32940KB
 */

 import java.io.*;
 import java.util.*;
 
 public class Prob20922 {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] selected = new int[100001];
        selected[numbers[0]] += 1;

        int start = 0;
        int end = 1;

        int answer = 1;
        while (end < N) {

            selected[numbers[end]] += 1;
            if (selected[numbers[end]] > K) {
                int check = start;
                while (check < end && selected[numbers[end]] > K) {
                    selected[numbers[check]] -= 1;
                    check++;
                }
                start = check;
            }
            
            answer = Math.max(answer, end - start + 1);
            end++;
        }

        System.out.println(answer);

    }
}
