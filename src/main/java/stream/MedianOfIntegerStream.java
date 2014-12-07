package stream;

import com.google.common.collect.MinMaxPriorityQueue;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Find running median of a infinite stream of integers
 * 
 */

public class MedianOfIntegerStream {
    /**
     * Using maxHeap and minHeap to store the values smaller and larger than
     * the current effective median.
     * 
     * The size difference of maxHeap and minHeap is at most 1.
     * 
     * Runtime complexity: O(nlog(n))
     * 1. The size of integer stream -> n
     * 2. The insertion of heap -> log(n)
     */
    
    // LEFT  -> maxHeap: stores integers smaller than effective median
    MinMaxPriorityQueue<Integer> maxHeap = MinMaxPriorityQueue.create();
    // RIGHT -> minHeap: stores integers larger than effective median
    MinMaxPriorityQueue<Integer> minHeap = MinMaxPriorityQueue.create();
    // effective median
    double median = Integer.MAX_VALUE;
    
    public double median(int value) {
        // heaps are empty
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.add(value); median = value;
        }
        // heaps are balanced
        else if (maxHeap.size() == minHeap.size()) {
            if (value < median) {
                maxHeap.add(value);
                median = maxHeap.peekLast();
            } else {
                minHeap.add(value);
                median = minHeap.peekFirst();
            }
        }
        // left maxHeap is larger by 1
        else if (maxHeap.size() > minHeap.size()) {
            if (value < median) {
                maxHeap.add(value);
                minHeap.add(maxHeap.pollLast());
            } else {
                minHeap.add(value);
            }
            median = (maxHeap.peekLast() + minHeap.peekFirst())/2.0;
        }
        // right minHeap is larger by 1
        else {
            if (value < median) {
                maxHeap.add(value);
            } else {
                minHeap.add(value);
                maxHeap.add(minHeap.peekFirst());
            }
            median = (maxHeap.peekLast() + minHeap.peekFirst())/2.0;
        }
        return median;
    }
    
    public static void main(String[] args) {
        MedianOfIntegerStream sol = new MedianOfIntegerStream();
        int[] A = {5, 15, 1, 3, 10, 2};
        for (int v : A) {
            System.out.println(String.format("Median of add %d: %.2f", v, sol.median(v)));
        }
    }
    
}
