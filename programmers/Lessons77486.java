import java.util.*;

public class Lessons77486 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/77486 */

    static final int COST = 100;
    static final String CENTER = "-";

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> family = new HashMap<>();
        Map<String, Integer> num = new HashMap<>();
        for(int i=0; i<enroll.length; i++) {
            family.put(enroll[i], referral[i]);
            num.put(enroll[i], i);
        }

        for(int i=0; i<seller.length; i++) {
            int value = amount[i] * COST;
            int tip = (int) (value * 0.1);
            answer[num.get(seller[i])] += value - tip;
            String next = family.get(seller[i]);
            while(!next.equals(CENTER)) {
                value = tip;
                if(value < 1) break;
                tip =  (int) (value * 0.1);
                answer[num.get(next)] += value - tip;
                next = family.get(next);
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(solution(enroll,
                referral,
                seller,
                amount)));
    }
}
