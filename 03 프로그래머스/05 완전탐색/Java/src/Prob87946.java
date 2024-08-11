
/**
* title  : 87946. 피로도 (Level 2)
*/

public class Prob87946 {
    
    static int answer;
    static int length;
    static boolean[] selected;
    
    public static void main(String[] args) {

        int k1 = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k1, dungeons));
    }   
    
    public static int solution(int k, int[][] dungeons) {
        
        answer = 0;
        length = dungeons.length;
        selected = new boolean[length];
        
        move(dungeons, k, 0);
        return answer;
    }
    
    public static void move(int[][] dungeons, int hp, int count) {
        
        answer = Math.max(count, answer);
    
        for (int i = 0; i < length; i++) {
            if (!selected[i] && dungeons[i][0] <= hp) {
                selected[i] = true;
                move(dungeons, hp-dungeons[i][1], count+1);
                selected[i] = false;
            }
        }
    }
}
