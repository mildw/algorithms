import java.util.*;

public class Lessons77486 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/154538 */

    public int solution(int x, int y, int n) {

        Queue<int[]> q = new PriorityQueue<>(
                (o1,o2) -> Integer.compare(o1[1], o2[1]));

        q.offer(new int[]{y,0});
        while(!q.isEmpty()) {
            int[] arr = q.poll();

            if(arr[0] == x) {
                return arr[1];
            }

            if(arr[0]-n >= x) {
                q.offer(new int[]{arr[0]-n, arr[1]+1});
            }
            if(arr[0]/2 >= x && arr[0]%2 == 0) {
                q.offer(new int[]{arr[0]/2, arr[1]+1});
            }
            if(arr[0]/3 >= x && arr[0]%3 == 0) {
                q.offer(new int[]{arr[0]/3, arr[1]+1});
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(solution(10,40,5,2));
    }
}
