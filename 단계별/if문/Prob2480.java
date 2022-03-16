package 단계별.if문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob2480 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 120ms 14104KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer (br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = 0;

        if ((a==b)&&(b==c)) {
            sum = 10000 + a*1000;
        } else if (((a==b)&&(b!=c)) || ((a==c)&&(a!=b))) {
            sum = 1000 + a*100;
        } else if ((b==c)&&(a!=b)) {
            sum = 1000 + b * 100;
        } else {
            if((a>b)&&(a>c)) {
                sum = a*100;
            } else if((b>c)&&(b>a)) {
                sum = b*100;
            } else {
                sum = c*100;
            }
        }

        // OPTION 4 : 132ms 14216KB

        if ((a==b)&&(b==c)) {
            sum = 10000 + a*1000;
        } else if ((a==b)||(a==c)) {
            sum = 1000 + a*100;
        } else if (b==c) {
            sum = 1000 + b * 100;
        } else {
            sum = Math.max(Math.max(a, b), c) * 100;
        }

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        bw.write(Integer.toString(sum));

        // OPTION 2 : 124ms 14344KB

        String a1 = st.nextToken();
        String b1 = st.nextToken();
        String c1 = st.nextToken();

        int anum = Integer.parseInt(a1);
        int bnum = Integer.parseInt(b1);
        int cnum = Integer.parseInt(c1);

        if (a1.equals(b1)&&b1.equals(c1)) {
            sum = 10000 + anum*1000;
        } else if (a1.equals(b1)|| a1.equals(c1)) {
            sum = 1000 + anum*100;
        } else if (b1.equals(c1)) {
            sum = 1000 + cnum * 100;
        } else {
            sum = Math.max(Math.max(anum, bnum), cnum) * 100;
        }

        bw.write(Integer.toString(sum));

        // OPTION 3 : 124ms 14332KB

        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (arr[2]==arr[0]) {
            sum = 10000 + arr[2] * 1000;
        } else if ((arr[1]==arr[0])||(arr[2]==arr[1])) {
            sum = 1000 + arr[1] * 100;
        } else {
            sum = arr[2] * 100;
        }

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();

        br.close();

    }
}
