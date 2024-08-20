
/**
* title  : 7785. 회사에 있는 사람 (Silver 5)
* time   : 604ms
* memory : 50428KB
*/

import java.io.*;
import java.util.*;

public class Prob7785 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> workMap = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                workMap.put(name, 1);
            } else {
                workMap.remove(name);
            }
        }

        List<String> keySet = new ArrayList<>(workMap.keySet());

        keySet.sort(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String key : keySet) {
            sb.append(key).append("\n");
        }

        System.out.println(sb);
    }

}
