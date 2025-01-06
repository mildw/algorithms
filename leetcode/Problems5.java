import org.junit.jupiter.api.Test;

import java.util.*;

public class Problems5 {

    /* https://leetcode.com/problems/longest-palindromic-substring/description/ */
    public String longestPalindrome(String s) {

        int max_len = s.length();
        for(int len=max_len; len>=1; len--){
            for(int start=0; start<max_len-len+1; start++){
                boolean flag = true;
                for(int i=0; i<=len/2; i++){
                    if(s.charAt(start+i)!=s.charAt(start+len-1-i)){
                        flag=false;break;
                    }
                }
                if(flag){return s.substring(start,start+len);}
            }
        }
        return s;
    }

    public void test() {
        System.out.println(solution("bb"));
    }

}
