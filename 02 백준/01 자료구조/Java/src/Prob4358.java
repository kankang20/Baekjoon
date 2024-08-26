
/**
* title  : 4358. 생태학 (Silver 2)
* time   : 596ms
* memory : 85324KB
*/

import java.io.*;
import java.util.*;

public class Prob4358 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> treeMap = new HashMap<>();
        
        String name;
        double allCount = 0;

        while (true) {
            name = br.readLine();
            if (name == null || name.length() == 0) break;

            treeMap.put(name, treeMap.getOrDefault(name, 0) + 1);
            allCount++;
        }

        List<String> treeList = new ArrayList<>(treeMap.keySet());
        Collections.sort(treeList);

        StringBuilder sb = new StringBuilder();
        for (String key : treeList) {
            sb.append(key)
                .append(" ")
                .append(String.format("%.4f", treeMap.get(key) / allCount * 100))
                .append("\n");
        }

        System.out.println(sb);
    }
}