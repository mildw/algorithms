import org.junit.jupiter.api.Test;

import java.util.*;

public class Lessons17677 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/12924 */

    class Solution {
        public int solution(int n) {
            if(n == 1 || n == 0) {
                return 1;
            }

            int answer = 1;

            int start = 1;
            int end = 1;
            while(end <= (n/2)+1) {
                int sum = 0;
                for(int i=start; i<=end; i++) {
                    sum +=i;
                }
                if(sum < n) {
                    end++;
                } else if (sum > n) {
                    start++;
                } else {
                    answer++;
                    start++;
                }
                if(start == end) {
                    end ++;
                }
            }
            return answer;
        }
    }

    public void test() {
        System.out.println(solution(15));
    }

}
