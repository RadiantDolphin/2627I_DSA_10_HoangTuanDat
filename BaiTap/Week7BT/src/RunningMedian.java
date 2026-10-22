import java.util.Collections;
import java.util.PriorityQueue;


import java.util.*;

public class RunningMedian {

    static PriorityQueue<Integer> lower =
            new PriorityQueue<>(Collections.reverseOrder());

    static PriorityQueue<Integer> upper =
            new PriorityQueue<>();

    static void addNumber(int x) {
        if (lower.isEmpty() || x <= lower.peek()) {
            lower.offer(x);
        } else {
            upper.offer(x);
        }

        // Rebalance
        if (lower.size() > upper.size() + 1) {
            upper.offer(lower.poll());
        } else if (upper.size() > lower.size() + 1) {
            lower.offer(upper.poll());
        }
    }

    static double getMedian() {
        if (lower.size() == upper.size()) {
            return (lower.peek() + upper.peek()) / 2f;
        }

        return (lower.size() > upper.size())
                ? lower.peek()
                : upper.peek();
    }

    public static void main(String[] args) {
        int[] nums = {12, 4, 5, 3, 8, 7};

        for (int x : nums) {
            addNumber(x);
            System.out.printf("%.1f%n", getMedian());
        }
    }
}
