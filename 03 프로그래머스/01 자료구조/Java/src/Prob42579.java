
/**
* title  : 42579. 베스트앨범 (Level 3)
*/

import java.util.*;

public class Prob42579 {
    
    public static void main(String[] args) {

        String[] g1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] p1 = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(g1, p1)));

        String[] g2 = {"classic", "classic", "classic", "pop", "pop"};
        int[] p2 = {600, 600, 150, 600, 700};
        System.out.println(Arrays.toString(solution(g2, p2)));
    } 

    public static int[] solution(String[] genres, int[] plays) {

        int length = genres.length;

        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, Map<Integer, Integer>> songMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            Map<Integer, Integer> temp = songMap.getOrDefault(genres[i], new HashMap<>());
            temp.put(i, plays[i]);
            songMap.put(genres[i], temp);
        }

        List<String> genreKey = new ArrayList<>(genreMap.keySet());
        genreKey.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -genreMap.get(o1).compareTo(genreMap.get(o2));
            }
        });

        List<Integer> answer = new ArrayList<>();
        for (String key : genreKey) {

            Map<Integer, Integer> temp = songMap.get(key);
            List<Integer> tempKeySet = new ArrayList<>(temp.keySet());

            tempKeySet.sort(new Comparator<Integer> (){
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (temp.get(o1) == temp.get(o2)) {
                        return o1.compareTo(o2);
                    } 
                    return -temp.get(o1).compareTo(temp.get(o2));
                }
            });

            for (int j = 0; j < 2 && j < tempKeySet.size(); j++) {
                answer.add(tempKeySet.get(j));
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
