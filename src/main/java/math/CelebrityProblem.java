package math;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * http://blog.csdn.net/fightforyourdream/article/details/17410993
 * https://www.cs.princeton.edu/courses/archive/spring13/cos423/problem0-1.pdf
 * http://www.geeksforgeeks.org/the-celebrity-problem/
 * 
 * 1. elimination phase
 * 2. verification phase
 */ 

public class CelebrityProblem {
    /*
     * Given a matrix of following between N LinkedIn users (with ids from 0 to N - 1):
     * followingMatrix[i][j] = true iff user i is following user j
     * thus followingMatrix[i][j] doesn't imply followingMatrix[j][i].
     * Let's also agree that followingMatrix[i][i] == false

     * Influencer is a user who is:
     * - followed by everyone else and
     * - not following anyone himself
     *
     * this method should find an Influencer by a given matrix of following,
     * or return -1 if there is no Influencer in this group
     */
    int getInfluencer(boolean[][] followingMatrix) {
        if (followingMatrix.length == 0 || followingMatrix[0].length == 0) return -1;
        // Phase 1. elimination
        int c = 0; // candidate
        for (int i = 1; i < followingMatrix.length; i++) {
            // Check if candidate
            if (followingMatrix[c][i] == true) c = i; // switch candidate
        }
        // Phase 2. validation
        for (int i = 0; i < followingMatrix.length; i++)
            if (followingMatrix[c][i] == true) return -1;  
        return c;
     }
}
