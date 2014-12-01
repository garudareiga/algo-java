package graph;

import java.util.Comparator;

import com.google.common.collect.MinMaxPriorityQueue;

/**
 * 
 * @author raychen
 * 
 * Problem:
 *  .......
    .......
    ..#.X..
    ....#..
    ..##...
    ..Y....

 * X: Start
 * Y: Destination
 * #: Block
 * Shortest Path from X to Y.
 */ 

public class ShortestPath {
    class Loc {
        public int x;
        public int y;
        public int path;
    }
    
    class LocComparator implements Comparator<Loc> {

        public int compare(Loc o1, Loc o2) {
            return o1.path - o2.path;
        }        
    }
    
    int shortestPath(char[][] grid) {
        Loc startLoc = new Loc(), endLoc = new Loc();
        int nrow = grid.length, ncol = grid[0].length;
        for (int r = 0; r < nrow; r++) {
            for (int c = 0; c < ncol; c++) {
                if (grid[r][c] == 'X') {
                    startLoc.x = c; startLoc.y = r;
                } else if (grid[r][c] == 'Y') {
                    endLoc.x = c; endLoc.y = r;
                }
            }
        }
        
        LocComparator comparator = new LocComparator();
        MinMaxPriorityQueue<Loc> q = MinMaxPriorityQueue.orderedBy(comparator).create();
        while (!q.isEmpty()) {
            Loc l = q.pollFirst();
            // finish Dijkistra's algorithm later
        }
        
        return 0;
    }
}
