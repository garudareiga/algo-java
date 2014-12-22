package math;

import java.util.*;
import util.Interval;

public class IntervalCoverage {
    public int getTotalCoverage(List<Interval> intervals) {
        List<Interval> merge = new LinkedList<Interval>();
        for (Interval interval : intervals)
            Interval.insert(merge, interval);
        int r = 0;
        for (Interval i : merge)
            r += i.end - i.start;
        return r;
    }
    
    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<Interval>();
        intervals.add(new Interval(3,6));
        intervals.add(new Interval(8,9));
        intervals.add(new Interval(1,5));
        
        IntervalCoverage ic = new IntervalCoverage();
        System.out.println(ic.getTotalCoverage(intervals)); // 6
    }
}
