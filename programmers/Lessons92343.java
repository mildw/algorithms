import java.util.*;

class Lessons92343 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/92343 */

    List<Integer>[] list;
    int answer = 0;
    void dfs(int cur, int[] info, List<Integer> possible, int sheep, int wolf) {
        
        if(info[cur] == 0) sheep++;
        else wolf++;
        
        if(wolf >= sheep) return;
        
        answer = Math.max(answer, sheep);
        
        List<Integer> nexts = new ArrayList<>(possible);
        nexts.remove(Integer.valueOf(cur));
        nexts.addAll(list[cur]);
        
        for(int i=0; i<nexts.size(); i++) {
            dfs(nexts.get(i), info, nexts, sheep, wolf);
        }
        
    }
    
    public int solution(int[] info, int[][] edges) {

        list = new ArrayList[info.length]; 
        for(int i=0; i<info.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            list[edge[0]].add(edge[1]);
        }
        
        dfs(0, info, new ArrayList<>(0) ,0,0);
        return answer;
    }
}