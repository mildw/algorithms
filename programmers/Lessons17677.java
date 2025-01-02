import org.junit.jupiter.api.Test;

import java.util.*;

public class Lessons17677 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/17677 */

    Set<String> keys = new HashSet<>();

    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.equals(str2)) {
            return 65536;
        }

        Map<String,Integer> map1 = sub(str1);
        Map<String,Integer> map2 = sub(str2);

        int count = 0 ;
        int all = 0 ;
        for(String key : keys) {
            Integer m1 = map1.getOrDefault(key,0);
            Integer m2 = map2.getOrDefault(key,0);

            System.out.println(key+ " " + m1+" / "+m2);

            if(m1 == m2) {
                all += m1;
                count+= m1;
            }else {
                all += Math.max(m1,m2);
                count+= Math.max(m1,m2) - Math.abs(m1-m2);
            }

        }

        if(count == 0) {
            return 0;
        }

        return (count *65536) / all ;
    }

    Map<String, Integer> sub(String str) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<str.length()-1; i++) {
            if(Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i+1))) {
                String s = str.substring(i,i+2);
                map.put(s, map.getOrDefault(s,0)+1);
                keys.add(s);
            }
        }
        return map;
    }

    public void test() {
        System.out.println(solution("FRANCE", "french"));
    }

}
