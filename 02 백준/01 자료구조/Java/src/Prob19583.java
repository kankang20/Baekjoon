
/**
* title  : 19583. 싸이버개강총회 (Silver 2)
* time   : 500ms
* memory : 69332KB
*/

import java.io.*;
import java.util.*;

public class Prob19583 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = timeToInt(st.nextToken());
        int E = timeToInt(st.nextToken());
        int Q = timeToInt(st.nextToken());

        HashMap<String, Integer> streaming = new HashMap<>();
        int answer = 0;

        String student;
        while ((student = br.readLine()) != null) {
            // if (student.length() < 3) break;

            st = new StringTokenizer(student);
            int now = timeToInt(st.nextToken());
            String name = st.nextToken();

            if (now <= S) {
                streaming.put(name, 1);
            } else if (E <= now && now <= Q) {
                if (streaming.getOrDefault(name, -1) == 1) {
                    streaming.replace(name, 0);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static int timeToInt(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}
