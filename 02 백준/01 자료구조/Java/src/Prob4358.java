
/**
* title  : 4358. 생태학 (Silver 2)
* time   : 768ms
* memory : 85620KB
*/

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Prob4358 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        
        String name;
        double allCount = 0;

        while (true) {
            name = br.readLine();
            if (name == null || name.length() == 0) break;

            treeMap.put(name, treeMap.getOrDefault(name, 0) + 1);
            allCount++;
        }

        StringBuilder sb = new StringBuilder();
        for (Entry<String, Integer> tree : treeMap.entrySet()) {
            sb.append(tree.getKey())
                .append(" ")
                .append(String.format("%.4f", tree.getValue() / allCount * 100))
                .append("\n");
        }

        System.out.println(sb);
    }
}