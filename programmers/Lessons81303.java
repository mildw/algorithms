import org.junit.jupiter.api.Test;

import java.util.*;

public class Lessons17677 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/81303 */

    public String solution(int n, int k, String[] cmd) {

        Stack<Node> stack = new Stack<>();
        Node node = initNode(n);
        for(int i=0; i<k; i++) {
            node = node.next;
        }

        for(String c : cmd) {
            String[] arr = c.split(" ");

            switch (arr[0]) {
                case "U":
                    for(int i=0; i<Integer.parseInt(arr[1]); i++) {
                        node = node.prev;
                    }
                    break;
                case "D":
                    for(int i=0; i<Integer.parseInt(arr[1]); i++) {
                        node = node.next;
                    }
                    break;
                case "C":
                    stack.add(node);
                    node.remove();
                    node = node.next.num == -1 ? node.prev : node.next;
                    break;
                case "Z":
                    stack.pop().restore();
                    break;
            }

        }

        StringBuilder answer = new StringBuilder("O".repeat(n));
        while (!stack.isEmpty()) {
            answer.setCharAt(stack.pop().num, 'X');
        }
        return answer.toString();

    }

    Node initNode(int n) {
        Node start = new Node(-1);
        Node prev = start;
        Node curr = null;
        for(int i=0; i<n; i++) {
            curr = new Node(i);
            prev.next = curr;
            curr.prev = prev;
            prev= curr;
        }
        curr.next = new Node(-1);
        return start.next;
    }

    class Node {

        int num;
        Node prev;
        Node next;

        Node() {
        }

        Node(int num) {
            this.num = num;
        }

        void remove() {
            prev.next = next;
            next.prev = prev;
        }

        void restore() {
            this.prev.next = this;
            this.next.prev = this;
        }

    }

    public void test() {
        System.out.println(solution(8,2,{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
    }

}
