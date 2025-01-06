import org.junit.jupiter.api.Test;

import java.util.*;

public class Problems1769 {

    /* https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/ */

    class Solution {
        public int[] minOperations(String boxes) {
            int[] answer = new int[boxes.length()];
            char[] chars = boxes.toCharArray();
            for(int i=0; i<chars.length; i++) {
                for(int j=0; j<chars.length; j++) {
                    if(i==j || chars[j]=='0') continue;
                    answer[i]+=Math.abs(i-j);
                }
            }

            return answer;
        }
    }

}
