// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        long travellingEast = 0;
        long passing = 0;
        for (int a : A) {
            if (a == 0) {
                travellingEast++;
            } else if (a == 1) {
                passing += travellingEast;
                if (passing > 1e9) {
                	return -1;
                }
            }
        }
        return (int) passing;
    }
}
