
/**
* title  : 20291. 파일 정리 (Silver 3)
* time   : 784ms
* memory : 65872KB
*/

import java.io.*;
import java.util.*;

public class Prob20291 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> nameMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = (br.readLine()).split("\\.")[1];
            nameMap.put(name, nameMap.getOrDefault(name, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(nameMap.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            sb.append(key).append(" ").append(nameMap.get(key)).append("\n");
        }

        System.out.println(sb);
    }
}