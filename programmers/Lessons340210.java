import java.util.*;

public class Lessons340210 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/340210 */

    public String[] solution(String[] expressions) {

        boolean[] possible = new boolean[10];
        Arrays.fill(possible, true);
        possible[0] = false;
        possible[1] = false;
        List<String> question = new ArrayList<>();
        for(String s : expressions) {
            String[] arr = s.split(" ");
            String left = arr[0];
            String oper = arr[1];
            String right = arr[2];
            String result = arr[4];

            if(result.equals("X")) {
                question.add(s);
            }

            for(int i=2; i<=9; i++) {
                try {
                    int cLeft = Integer.valueOf(left, i);
                    int cRight = Integer.valueOf(right, i);
                }catch(Exception e) {
                    possible[i] = false;
                }

                if(!result.equals("X") && possible[i])
                    possible[i] = compare(left, oper, right, i, result);
            }

        }

        int idx = 0;
        String[] answer = new String[question.size()];

        for(String q : question) {
            String[] arr = q.split(" ");
            String left = arr[0];
            String oper = arr[1];
            String right = arr[2];
            String result = arr[4];

            List<String> results = new ArrayList<>();
            for(int i=2; i<=9; i++) {
                if(!possible[i])continue;
                try {
                    int cResult = calc(left, oper, right, i);
                    results.add(convert(cResult, i));
                }catch (Exception e) {
                    possible[i]=false;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(left).append(" ").append(oper).append(" ").append(right).append(" = ");
            String first = results.get(0);
            if(results.stream().allMatch(element -> element.equals(first))) {
                sb.append(first);
            }else {
                sb.append("?");
            }
            answer[idx++] = sb.toString();

        }

        return answer;
    }

    public String convert(int number, int jinsu) {
        StringBuilder sb = new StringBuilder();
        if (number == 0) {
            return "0";
        }

        while (number > 0) {
            sb.insert(0, number % jinsu);
            number /= jinsu;
        }
        return sb.toString();
    }

    public boolean compare(String left, String oper, String right, int jinsu, String result) {
        try {
            int cResult = calc(left, oper, right, jinsu);
            if(cResult != Integer.valueOf(result, jinsu)) {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public int calc(String left, String oper, String right, int jinsu) {
        switch (oper) {
            case "+" :
                return Integer.valueOf(left, jinsu) + Integer.valueOf(right, jinsu);
            case "-" :
                return Integer.valueOf(left, jinsu) - Integer.valueOf(right, jinsu);
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] expressions = new String[]{
                "2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "5 - 5 = X"
        };
        System.out.println(Arrays.toString(solution(expressions)));
        System.out.println("hello world");
    }
}
