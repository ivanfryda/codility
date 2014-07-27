// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int[] peaks = new int[A.length];
        int peakCount = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                peaks[peakCount] = i;
                peakCount++;
            }
        }
        int result = 0;
        int factor = 1;
        while (factor <= peakCount && factor <= A.length / 2) {
			if (canBeDividedInto(factor, peaks, A)) {
				result = factor; 
            }
            factor++;
        }
        return result;
    }
    private boolean canBeDividedInto(int blocks, int[] peaks, int[] A) {
		if (A.length % blocks != 0) {
			return false;
		}
        int blockSize = A.length / blocks;
		int from = 0;
        int to = from + blockSize - 1;
        while (to < A.length) {
            if (!hasPeaks(peaks, A, from, to)) {
                return false;
            }
            from = to + 1;
            to += blockSize;
        }
        return true;
    }
    private boolean hasPeaks(int[] peaks, int[] A, int from, int to) {
        for (int i = 0; peaks[i] != 0; i++) {
            if (peaks[i] >= from && peaks[i] <= to) {
                return true;
            }
        }
        return false;
    }
}