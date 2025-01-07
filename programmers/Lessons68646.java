import org.junit.jupiter.api.Test;

import java.util.*;

public class Lessons68646 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/68646 */

    public int solution(int[] a) {

        Set<Integer> set = new HashSet<>();
        int lmin = a[0];
        int rmin = a[a.length - 1];
        set.add(a[0]);
        set.add(a[a.length - 1]);
        for (int i = 1; i < a.length; i++) {
            if (a[i] < lmin) {
                set.add(a[i]);
                lmin = a[i];
            }
            if (a[a.length - 1 - i] < rmin) {
                set.add(a[a.length - 1 - i]);
                rmin = a[a.length - 1 - i];
            }
        }

        return set.size();
    }

}