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
        public int estimatedPath;
        private final static int epsilon = 1; // If change epsilon to 5, weighted A* search, converge faster

        public int getTotalPath() { return path + epsilon*estimatedPath; }
        Loc(int x, int y, int path) { this.x = x; this.y = y; this.path = path; }
    }
    
    class LocComparator implements Comparator<Loc> {
        public int compare(Loc o1, Loc o2) {
            return o1.path - o2.path;
        }        
    }
    
    class AStarComparator implements Comparator<Loc> {
        public int compare(Loc o1, Loc o2) {
            return o1.getTotalPath() - o2.getTotalPath();
        }        
    }
        
    int shortestPath(char[][] grid) {
        Loc startLoc = null, endLoc = null;
        int nrow = grid.length, ncol = grid[0].length;
        for (int r = 0; r < nrow; r++) {
            for (int c = 0; c < ncol; c++) {
                if (grid[r][c] == 'X') {
                    startLoc = new Loc(c, r, 0);
                } else if (grid[r][c] == 'Y') {
                    endLoc = new Loc(c, r, -1);
                }
            }
        }
        
        boolean[][] visited = new boolean[nrow][ncol];
        LocComparator comparator = new LocComparator();
        MinMaxPriorityQueue<Loc> q = MinMaxPriorityQueue.orderedBy(comparator).create();
        q.add(startLoc);
        int count = 0;
        Loc next = null;
        while (!q.isEmpty()) {
            count++;
            Loc loc = q.pollFirst();
            if (loc.x == endLoc.x && loc.y == endLoc.y) { endLoc.path = loc.path; break; }
            next = nextLoc(loc.y, loc.x - 1, loc.path + 1, grid, visited);
            if (next != null) q.add(next);
            next = nextLoc(loc.y, loc.x + 1, loc.path + 1, grid, visited);
            if (next != null) q.add(next);
            next = nextLoc(loc.y - 1, loc.x, loc.path + 1, grid, visited);
            if (next != null) q.add(next);
            next = nextLoc(loc.y + 1, loc.x, loc.path + 1, grid, visited);
            if (next != null) q.add(next);
        }
        System.out.println("Iteration Count=" + count);
        return endLoc.path;
    }

    int astarPath(char[][] grid) {
        Loc startLoc = null, endLoc = null;
        int nrow = grid.length, ncol = grid[0].length;
        for (int r = 0; r < nrow; r++) {
            for (int c = 0; c < ncol; c++) {
                if (grid[r][c] == 'X') {
                    startLoc = new Loc(c, r, 0);
                } else if (grid[r][c] == 'Y') {
                    endLoc = new Loc(c, r, -1);
                }
            }
        }
        
        boolean[][] visited = new boolean[nrow][ncol];
        AStarComparator comparator = new AStarComparator();
        MinMaxPriorityQueue<Loc> q = MinMaxPriorityQueue.orderedBy(comparator).create();
        q.add(startLoc);
        int count = 0;
        Loc next = null;
        while (!q.isEmpty()) {
            count++;
            Loc loc = q.pollFirst();
            if (loc.x == endLoc.x && loc.y == endLoc.y) { endLoc.path = loc.path; break; }
            next = nextLoc(loc.y, loc.x - 1, loc.path + 1, grid, visited);
            if (next != null) {
                next.estimatedPath = getManhattanDistance(next, endLoc);
                q.add(next);
            }
            next = nextLoc(loc.y, loc.x + 1, loc.path + 1, grid, visited);
            if (next != null) {
                next.estimatedPath = getManhattanDistance(next, endLoc);
                q.add(next);
            }
            next = nextLoc(loc.y - 1, loc.x, loc.path + 1, grid, visited);
            if (next != null) {
                next.estimatedPath = getManhattanDistance(next, endLoc);
                q.add(next);
            }
            next = nextLoc(loc.y + 1, loc.x, loc.path + 1, grid, visited);
            if (next != null) {
                next.estimatedPath = getManhattanDistance(next, endLoc);
                q.add(next);
            }
        }
        System.out.println("Iteration Count=" + count);
        return endLoc.path;
    }  
    
    private Loc nextLoc(int r, int c, int path, char[][] grid, boolean[][] visited) {
        if (r < 0 || r >= grid.length) return null;
        if (c < 0 || c >= grid[0].length) return null;
        if (grid[r][c] == '#' || visited[r][c]) return null;
        visited[r][c] = true;
        return new Loc(c, r, path);
    }
    
    public static int getManhattanDistance(Loc loc1, Loc loc2) {
        return Math.abs(loc1.x - loc2.x) + Math.abs(loc1.y - loc2.y);
    }
    
    public static void main(String[] args) {
        char[][] grid = {
            {'.','.','.','.','.','.','.'},
            {'.','.','#','.','X','.','.'},
            {'.','.','.','.','#','#','.'},
            {'.','.','#','#','.','.','.'},
            {'.','.','Y','.','.','.','.'},
            {'.','.','.','.','.','.','.'},
        };
        ShortestPath sp = new ShortestPath();
        System.out.println(sp.shortestPath(grid));
        System.out.println(sp.astarPath(grid));
    }
}
