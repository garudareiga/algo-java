package greedy;

import util.Interval;

import java.util.*;

import com.google.common.collect.*;

/*
 * Problem:
 * Given an array of intervals of meetings (as in int),
 * 1) Determine if a single person can attend all the meetings.
 * 2) Determine the minimum number of meeting rooms needed to hold all the meetings.
 * 
 * For example,
 * Input (1,4), (4,5), (3,4), (2,3)
 * Output: 1) false and 2) 2 rooms
 */

public class IntervalScheduling {
    ArrayList<Interval> intervals = null;
    
    public IntervalScheduling(ArrayList<Interval> intervals) {
        this.intervals = intervals;
        Collections.sort(this.intervals);
    }
    
    public boolean isAttendable() {
        int finish = -1;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start < finish) return false;
            finish = intervals.get(i).end;
        }
        return true;
    }
    
    public int maxMeetingRoom() {
        MinMaxPriorityQueue<Integer> q = MinMaxPriorityQueue.create();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (q.isEmpty()) q.add(interval.end);
            else {
                if (q.peekFirst() <= interval.start) q.pollFirst();
                q.add(interval.end);
            }
        }
        return q.size();
    }
    
    public static void main(String[] args) {
        ArrayList<Interval> array = new ArrayList<Interval>();
        array.add(new Interval(1, 4));
        array.add(new Interval(4, 5));
        array.add(new Interval(3, 4));
        array.add(new Interval(2, 3));
        
        IntervalScheduling sol = new IntervalScheduling(array);
        System.out.println(sol.isAttendable());
        System.out.println(sol.maxMeetingRoom());
    }
}
