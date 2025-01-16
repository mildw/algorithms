import java.util.*;

public class Lessons150365 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/150365 */

    private static final char[] directions = {'d', 'l', 'r', 'u'};
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, -1, 1, 0};
    private String answer = "impossible";

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(r - x) + Math.abs(c - y);
        if (dist > k || (k - dist) % 2 != 0) {
            return "impossible";
        }

        dfs(n, m, x, y, r, c, k, new StringBuilder());
        return answer;
    }

    private void dfs(int n, int m, int x, int y, int r, int c, int k, StringBuilder path) {
        if (!answer.equals("impossible")) return;
        if (k == 0) {
            if (x == r && y == c) {
                answer = path.toString();
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                int remainingDist = Math.abs(r - nx) + Math.abs(c - ny);
                if (remainingDist <= k - 1) {
                    path.append(directions[i]);
                    dfs(n, m, nx, ny, r, c, k - 1, path);
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }
    }
}
