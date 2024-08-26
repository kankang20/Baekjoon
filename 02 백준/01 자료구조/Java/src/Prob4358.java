
/**
* title  : 4358. 생태학 (Silver 2)
* time   : ms
* memory : KB
*/

import java.io.*;
import java.util.*;

public class Prob4358 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> treeMap = new HashMap<>();
        
        String name = "";
        int allCount = 0;

        while ((name = br.readLine()) != null) {
            treeMap.put(name, treeMap.getOrDefault(name, 0) + 1);
            allCount++;
        }

        System.out.println(allCount);

    }
}