
/**
* title  : 16165. 걸그룹 마스터 준석이 (Silver 3)
* time   : 104ms
* memory : 14072KB
*/

import java.io.*;
import java.util.*;

public class Prob16165 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, List<String>> groupMap = new HashMap<>();
        HashMap<String, String> memberMap = new HashMap<>();

        for (int i = 0; i < N; i++) {

            String groupName = br.readLine();
            groupMap.put(groupName, new ArrayList<>());

            int count = Integer.parseInt(br.readLine());
            for (int j = 0; j < count; j++) {
                String memberName = br.readLine();
                groupMap.get(groupName).add(memberName);
                memberMap.put(memberName, groupName);
            }
        }

        for (int i = 0; i < M; i++) {

            String name = br.readLine();
            String check = br.readLine();

            if (check.equals("1")) {
                System.out.println(memberMap.get(name));
            } else {

                List<String> temp = groupMap.get(name);
                Collections.sort(temp);

                for (String tt : temp) {
                    System.out.println(tt);
                }
            }
        }
    }
}