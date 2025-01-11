import java.util.*;

public class Lessons49190 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/49190 */

    int[][] dydx= { {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1} };

    public int solution(int[] arrows) {
        int answer = 0;
        Map<Node, List<Node>> map = new HashMap<>();
        Node cur = new Node(0,0);
        map.put(cur, new ArrayList<>());
        for(int a : arrows) {
            for(int i=0; i<2; i++) {
                Node next = new Node(cur.y+dydx[a][0], cur.x+dydx[a][1]);
                List<Node> clist = map.get(cur);
                List<Node> nlist = map.getOrDefault(next, new ArrayList<>());

                clist.add(next);
                if(nlist.size() == 0) {
                    nlist.add(cur);
                } else if(!nlist.contains(cur)) {
                    nlist.add(cur);
                    answer++;
                }

                map.put(cur, clist);
                map.put(next, nlist);
                cur = next;
            }
        }

        return answer;
    }

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y =y;
            this.x =x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

}