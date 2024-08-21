
/**
* title  : 13414. 수강신청 (Silver 3)
* time   : 628ms
* memory : 65448KB
*/

import java.io.*;
import java.util.*;

public class Prob13414 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Set<String> studentMap = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String id = br.readLine();
            
            if (studentMap.contains(id)) {
                studentMap.remove(id);
            }

            studentMap.add(id);
        }

        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (String id : studentMap) {
            sb.append(id).append("\n");
            count++;

            if (K <= count) {
                break;
            }
        }

        System.out.println(sb);
    }
}