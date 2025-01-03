import org.junit.jupiter.api.Test;

import java.util.*;

public class Lessons17677 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/17678 */

    public String solution(int n, int t, int m, String[] timetable) {

        String[] bus = new String[n];
        int startHour = 9, startMinute = 0;
        for (int i = 0; i < n; i++) {
            int totalMinutes = startHour * 60 + startMinute + (i * t);
            bus[i] = String.format("%02d:%02d", totalMinutes / 60, totalMinutes % 60);
        }

        Arrays.sort(timetable);

        int timeIdx = 0;
        for(int i=0; i<n; i++) {
            int possible = m;
            while(possible > 0 && timeIdx < timetable.length && timetable[timeIdx].compareTo(bus[i]) <= 0) {
                timeIdx++;
                possible--;
            }

            if(i == n-1) {
                if(possible > 0) {
                    return bus[i];
                }else {
                    int hour = Integer.parseInt(timetable[timeIdx-1].split(":")[0]);
                    int min = Integer.parseInt(timetable[timeIdx-1].split(":")[1]);
                    int total = hour*60+min-1;
                    return String.format("%02d:%02d", total / 60, total % 60);
                }
            }
        }

        return "";
    }

    public void test() {
        System.out.println(solution(
                1,1,5,{"08:00", "08:01", "08:02", "08:03"}
        ));
    }

}
