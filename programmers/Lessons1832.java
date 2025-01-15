import org.junit.jupiter.api.Test;

import java.util.*;

public class Lessons1832 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/1832 */

    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] map = new int[m][n][2];

        for (int i = 1; i < m; i++) {
            if (cityMap[i][0] == 1) break;
            map[i][0][0]++;
        }

        for (int i = 1; i < n; i++) {
            if (cityMap[0][i] == 1) break;
            map[0][i][1]++;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) continue;
                map[i][j][0] = (map[i][j][0] + map[i - 1][j][0]) % MOD;
                map[i][j][1] = (map[i][j - 1][1] + map[i][j][1]) % MOD;

                if (cityMap[i - 1][j] != 2) {
                    map[i][j][0] = (map[i - 1][j][1] + map[i][j][0]) % MOD;
                }

                if (cityMap[i][j - 1] != 2) {
                    map[i][j][1] = (map[i][j - 1][0] + map[i][j][1]) % MOD;
                }

            }
        }

        return (map[m - 1][n - 1][0] + map[m - 1][n - 1][1]) % MOD;
    }

}
