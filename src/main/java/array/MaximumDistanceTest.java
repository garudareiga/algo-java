package array;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximumDistanceTest {

    @Test
    public void test() {
        int[] A = {4,3,5,2,1,3,2,3};
        MaximumDistance sol = new MaximumDistance();
        assertEquals(4, sol.maximumDistance(A));
    }

}
