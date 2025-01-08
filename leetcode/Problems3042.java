import org.junit.jupiter.api.Test;

import java.util.*;

public class Problems5 {

    /* https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/ */
    public int countPrefixSuffixPairs(String[] words) {
        int answer = 0;
        for(int i=0; i<words.length; i++) {
            for(int j=i+1; j<words.length; j++) {
                if(i==j) continue;
                if(isPrefixAndSuffix(words[i], words[j])) {
                    answer++;
                }
            }
        }
        return answer;
    }

    boolean isPrefixAndSuffix(String str1 ,String str2) {
        if(str2.length() < str1.length()) return false;
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)
                    || str1.charAt(str1.length()-1-i) != str2.charAt(str2.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

}
