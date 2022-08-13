package BOJ.단계별로_풀어보기.Step10_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 148ms 15840KB

class Man {
    int weight;  // 몸무게
    int height;  // 키
}

public class Prob7568_1 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());

        ArrayList<Man> mans = new ArrayList<>();

        for (int i = 0; i < number; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Man man = new Man();
            man.weight = x;
            man.height = y;
            
            mans.add(man);
        }

        for (int i = 0; i < number; i++) {

            Man MMan = mans.get(i);
            int count = 1;

            for (int j = 0; j < number; j++) {
                
                if (j != i) {

                    Man mman = mans.get(j);

                    if (MMan.weight < mman.weight && MMan.height < mman.height) count++;
                }
            }

            sb.append(count + " ");
        }

        System.out.println(sb);
        br.close();
    }
}