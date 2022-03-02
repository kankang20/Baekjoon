import java.io.IOException;

public class Prob15596 {
    static long sum(int[] a) {

        long ans = 0;
        
        // OPTION 1 : 36ms 422800KB
        
        for(long i : a) {
            ans += i;
        }

        // OPTION 2 : 24ms 423296KB

        for(int i = 0; i <a.length; i++) {
            ans += a[i];
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        
        StringBuilder sb = new StringBuilder();

        int[] test = {1, 2, 3, 4, 5};

        sb.append(sum(test));
        System.out.println(sb);
    }
}
