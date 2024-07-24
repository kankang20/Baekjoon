package 정렬;

import java.io.*;
import java.util.*;

public class Prob11650 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<int[]> coordinate = new ArrayList<>();
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinate.add(new int[] {x, y});
        }

        Collections.sort(coordinate, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < N; i++) {
            int[] temp = coordinate.get(i);
            sb.append(temp[0] + " " + temp[1]).append("\n");
        }

        System.out.println(sb);
    }
}
