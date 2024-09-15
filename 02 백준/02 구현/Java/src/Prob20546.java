
/**
 * title  : 20546. 기적의 매매법 (Silver 5)
 * time   : 100ms
 * memory : 14240KB
 */

import java.io.*;
import java.util.*;

public class Prob20546 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Length = 14;

        int money =  Integer.parseInt(br.readLine());
        int[] price = new int[Length];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int amoney = money;
        int acount = 0;

        int bmoney = money;
        int bcount = 0;

        for (int p : price) {
            acount += (amoney / p);
            amoney %= p;
        }

        for (int i = 3; i < Length; i++) {

            if (price[i-3] < price[i-2] && price[i-2] < price[i-1] && price[i-1] < price[i]) {
                bmoney += (price[i] * bcount);
                bcount = 0;
            } else if (price[i-3] > price[i-2] && price[i-2] > price[i-1] && price[i-1] > price[i]) {
                bcount += (bmoney / price[i]);
                bmoney %= price[i];
            }
        }

        int aanswer = amoney + acount * price[Length-1];
        int banswer = bmoney + bcount * price[Length-1];

        if (aanswer == banswer) System.out.println("SAMESAME");
        else if (aanswer < banswer) System.out.println("TIMING");
        else System.out.println("BNP");
    }
}