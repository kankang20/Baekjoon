package BOJ.단계별로_풀어보기.Step5_함수;

// 36ms 422800KB

public class Prob15596_1 {
    long sum(int[] a) {
        long ans = 0;
        
        for(long i : a) {
            ans += i;
        }
        
        return ans;
    }
}
