
/**
* title  : 13414. 수강신청 (Silver 3)
* time   : 1156ms
* memory : 70348KB
*/

import java.io.*;
import java.util.*;

public class Prob13414 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> studentMap = new HashMap<>();
        for (int i = 0; i < L; i++) {
            String id = br.readLine();
            studentMap.put(id, i);
        }

        List<String> keySet = new ArrayList<>(studentMap.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return studentMap.get(o1) - studentMap.get(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K && i < keySet.size(); i++) {
            sb.append(keySet.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}