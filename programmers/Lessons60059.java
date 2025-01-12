import java.util.*;

class Lessons60059 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/60059 */

    boolean answer = false;
    int M;
    int N;

    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;
        int[][] largeLock = new int[2*M+N][2*M+N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                largeLock[i+M][j+M] = lock[i][j];
            }
        }

        for(int k=0; k<4; k++) {

            for(int i=0; i<M+N; i++) {
                for(int j=0; j<M+N; j++) {
                    if(match(largeLock, key, i,j)) {
                        return true;
                    }
                    rollback(largeLock, key, i,j);
                }
            }
            key = rotate(key);
        }
        return false;
    }

    int[][] rotate(int[][] key) {
        int len = key.length;
        int[][] newKey = new int[len][len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                newKey[j][len-1-i] = key[i][j];
            }
        }
        return newKey;
    }

    boolean match(int[][] lock, int[][] key, int y, int x) {
        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
                lock[y+i][x+j] +=  key[i][j];
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(lock[M+i][M+j] != 1) return false;
            }
        }

        return true;
    }

    void rollback(int[][] lock, int[][] key, int y, int x) {
        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
                lock[y+i][x+j] -=  key[i][j];
            }
        }
    }

}