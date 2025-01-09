import org.junit.jupiter.api.Test;

import java.util.*;

public class Problems118 {

    /* https://leetcode.com/problems/pascals-triangle/description/ */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1));
        if (numRows == 1) {
            return list;
        }
        list.add(List.of(1, 1));
        if (numRows == 2) {
            return list;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            for (int j = 1; j < i - 1; j++) {
                List<Integer> temp = list.get(i - 2);
                l.add(temp.get(j - 1) + temp.get(j));
            }
            l.add(1);
            list.add(l);
        }
        return list;
    }

}
