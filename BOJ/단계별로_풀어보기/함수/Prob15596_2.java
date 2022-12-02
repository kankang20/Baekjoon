package BOJ.단계별로_풀어보기.함수;

// 정수 N개의 합 24ms 423296KB

public class Prob15596_2 {
    long sum(int[] a) {
        long ans = 0;

        for (int i = 0; i < a.length; i++) {
            ans += a[i];
        }

        return ans;
    }
}
