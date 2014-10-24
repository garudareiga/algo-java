package util;

import java.util.List;
import java.util.ListIterator;

public class Interval {
	public int start;
	public int end;
	public Interval() { start = 0; end = 0; }
	public Interval(int s, int e) { start = s; end = e; }
	
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	ListIterator<Interval> iter = intervals.listIterator();
    	while (iter.hasNext()) {
    		Interval current = iter.next();
    		if (newInterval.end < current.start) {
    			intervals.add(iter.previousIndex(), newInterval);
    			return intervals;
    		} else if (newInterval.start > current.end) {
    			continue;
    		} else {
        		newInterval.start = Math.min(current.start, newInterval.start);
        		newInterval.end = Math.max(current.end, newInterval.end);
        		iter.remove();
    		}
    	}
    	intervals.add(newInterval);
      	return intervals;
    }
}
