import java.util.LinkedList;

// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        if (S.length() % 2 != 0) {
            return 0;
        }
        LinkedList<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < S.length(); i++) {
            if (isOpening(S.charAt(i))) {
                queue.push(S.charAt(i));
            } else {
                if (queue.isEmpty() || !match(queue.pop(), S.charAt(i))) {
                    return 0;
                }
            }
        }
        return 1;
    }
    private boolean isOpening(char aChar) {
        return aChar == '(' || aChar == '[' || aChar == '{';
    }
    private boolean match(char opening, char closing) {
        if (opening == '(') return closing == ')';
        if (opening == '[') return closing == ']';
        if (opening == '{') return closing == '}';
        return false;
    }
}
