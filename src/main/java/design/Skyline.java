package design;

import java.util.*;
import util.Point;

import com.google.common.collect.MinMaxPriorityQueue;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * You are given a set of n rectangles in no particular order. 
 * They have varying widths and heights, but their bottom edges 
 * are collinear, so that they look like buildings on a skyline. 
 * For each rectangle, you’re given the x position of the left edge, 
 * the x position of the right edge, and the height. Your task is to 
 * draw an outline around the set of rectangles so that you can see 
 * what the skyline would look like when silhouetted at night.
 * 
 * 1) https://briangordon.github.io/2014/08/the-skyline-problem.html
 *    Follow the final solution here.
 *    a) Left point increase
 *    b) right point decrease
 *    c) Using stack to main the largest height
 *    d) If the number of rectangle is very large, read in one by one
 *       Maintain a heap of critical points, read next rectangle if its left point
 *       is smaller than the smallest right points
 *       
 * http://www.shadabahmed.com/blog/2013/04/24/skyline-algorithm-a-binary-tree-approach
 */ 

public class Skyline {
    static class Rectangle implements Comparable<Rectangle> {
        int lx;
        int rx;
        int height;
        
        public Rectangle(int lx, int height, int rx) {
            this.lx = lx;
            this.rx = rx;
            this.height = height;
        }
        
        public int compareTo(Rectangle rect) {
            return this.height - rect.height;
        }
    }
    
    static class CriticalPoint implements Comparable<CriticalPoint> {
        int x;
        Rectangle rect;
        
        public CriticalPoint(int x, Rectangle rect) {
            this.x = x;
            this.rect = rect;
        }
        
        public int compareTo(CriticalPoint point) {
            return this.x - point.x;
        }
        
        public String toString() {
            return x + " rect_height=" + rect.height;
        }
    }
    
    boolean isLeftPoint(CriticalPoint point) {
        return point.x == point.rect.lx;
    }
    
    List<Point> skyline(ArrayList<Rectangle> rectangles) {
        List<Point> result = new ArrayList<Point>();
        
        ArrayList<CriticalPoint> points = new ArrayList<CriticalPoint>();
        for (Rectangle rect : rectangles) {
            points.add(new CriticalPoint(rect.lx, rect));
            points.add(new CriticalPoint(rect.rx, rect));
        }
        Collections.sort(points);
        
        MinMaxPriorityQueue<Rectangle> rectQueue = MinMaxPriorityQueue.create();
        
        for (CriticalPoint point : points) {
            if (isLeftPoint(point)) {
                // Left point increase
                if (rectQueue.isEmpty() || rectQueue.peekLast().height < point.rect.height)
                    result.add(new Point(point.x, point.rect.height));
                rectQueue.add(point.rect);
            } else {
                rectQueue.remove(point.rect);
                // Right point decrease
                if (rectQueue.isEmpty()) 
                    result.add(new Point(point.x, 0));
                else if (rectQueue.peekLast().height < point.rect.height)
                    result.add(new Point(point.x, rectQueue.peekLast().height));
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
        rectangles.add(new Rectangle( 1, 11,  5));
        rectangles.add(new Rectangle( 2,  6,  7));
        rectangles.add(new Rectangle( 3, 13,  9));
        rectangles.add(new Rectangle(12,  7, 16));
        rectangles.add(new Rectangle(14,  3, 25));
        rectangles.add(new Rectangle(19, 18, 22));
        rectangles.add(new Rectangle(23, 13, 29));
        rectangles.add(new Rectangle(24,  4, 28));
        
        Skyline skyline = new Skyline();
        List<Point> points = skyline.skyline(rectangles);
        // (1, 11), (3, 13), (9, 0), (12, 7), (16, 3), (19, 18), (22, 3), (23, 13), (29, 0)        
        for (Point point : points) {
            System.out.println(point.toString());
        }
    }
}
