
/**
* title  : 6266. [21년 재직자 대회 예선] 회의실 예약 (Level 2)
* time   : 146ms
* memory : 12.43MB
*/

import java.io.*;
import java.util.*;

public class Prob6266 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] room_name = new String[N];
        for (int i = 0; i < N; i++) {
            room_name[i] = br.readLine();
        }
        
        HashMap<String,List<int[]>> reservation = new HashMap<>();
        for (int i = 0; i < N; i++) {
            reservation.put(room_name[i], new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            reservation.get(name).add(new int[] {start, end});
        }

        Arrays.sort(room_name);

        for (int i = 0; i < N; i++) {
            String name = room_name[i];
            System.out.printf("Room %s:\n", name);
            
            List<int[]> possible_time = check_time(reservation.get(name));

            int length = possible_time.size();
            if (length == 0) {
                System.out.println("Not available");
            } else {
                System.out.printf("%d available:\n", length);
                 for (int[] pt : possible_time) {
                    System.out.println(String.format("%02d-%02d", pt[0], pt[1]));
                }   
            }
            
            if (i < (N-1)) {
                System.out.println("-----");
            }
        }
        
    }

    public static List<int[]> check_time(List<int[]> table) {

        Collections.sort(table, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> available_time = new ArrayList<>();
        
        int ss = 9;
        for (int[] t : table) {
            if (ss < t[0]) {
                available_time.add(new int[] {ss, t[0]});
            }
            ss = t[1];
        }

        if (ss < 18) {
            available_time.add(new int[] {ss, 18});
        }

        return available_time;
    }
}
