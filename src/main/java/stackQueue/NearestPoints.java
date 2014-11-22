package stackQueue;

import util.Point;
import java.util.*;
import com.google.common.collect.MinMaxPriorityQueue;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Stored a list of points. 
 * Given a 'center' point, returns a subset of 'm' stored points
 * that are closer to the center than others
 * 
 * For example, store (0, 1) (0, 2) (0, 3) (0, 4) (0, 5)
 *
 * findNearest(new Point(0, 0), 3) -> (0, 1), (0, 2), (0, 3)
 */ 

public class NearestPoints {
    final List<Point> points;
    
    public NearestPoints(List<Point> points) {
        this.points = points;
    }
   
    List<Point> findNearest(Point center, int m) {
        PointComparator comparator = new PointComparator(center);
        MinMaxPriorityQueue<Point> pq = MinMaxPriorityQueue.
                orderedBy(comparator).maximumSize(m).create();
        for (Point p : points) pq.add(p);
        List<Point> result = new ArrayList<Point>();
        for (Point p : pq) result.add(p);
        return result;
    }
    
    class PointComparator implements Comparator<Point> {
        final Point center;
        
        public PointComparator(Point center) {
            this.center = center;
        }
        
        public int compare(Point p1, Point p2) {
            double d1 = distance(p1, center);
            double d2 = distance(p2, center);
            if (d1 > d2) return 1;
            else if (d1 < d2) return -1;
            else return 0;
        }
    }
    
    double distance(Point p1, Point p2) {
        return Math.sqrt(p1.x - p2.x) + Math.sqrt(p1.y - p2.y);
    }
    
    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 5));
        points.add(new Point(0, 2));
        points.add(new Point(0, 4));
        points.add(new Point(0, 3));
        points.add(new Point(0, 1));
        
        NearestPoints sol = new NearestPoints(points);
        List<Point> result = sol.findNearest(new Point(0, 0), 3);
        for (Point p : result) 
            System.out.println(p.toString());
    }
}
