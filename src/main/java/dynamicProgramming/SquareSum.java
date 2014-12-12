package dynamicProgramming;

import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Find the least number of squared value which sum to a target.
 * 
 * input: 14 -> output: 9, 4, 1
 * input: 50 -> output: 25, 25
 */ 

public class SquareSum {
	int minSquareSumNum(int input) {
		int[] result = new int[input + 1];
		result[0] = 0;
		for (int i = 1; i <= input; i++) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while (j*j <= i) {
				min = Math.min(min, 1 + result[i - j*j]);
				j++;
			}
			result[i] = min;
		}
		return result[input];
	}
	
	List<Integer> minSquareSum(int input) {
		List<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> squares = new ArrayList<Integer>();
		for (int i = 1; i*i <= input; i++) squares.add(i*i);
		
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
		array.add(new ArrayList<Integer>());
		for (int i = 1; i <= input; i++) {
			ArrayList<Integer> minCurr = null;
			int minPrev = Integer.MAX_VALUE;
			for (int j = 0; j < squares.size(); j++) {
				if (i - squares.get(j) < 0) break;
				ArrayList<Integer> prev = array.get(i - squares.get(j));
				if (prev.size() < minPrev) {
					minPrev = prev.size();
					minCurr = new ArrayList<Integer>(prev);
					minCurr.add(squares.get(j));
					if (minCurr.size() == 2) break;
				}
			}
			array.add(minCurr);
		}
		result = array.get(input);
		return result;
	}
	
	public static void main(String[] args) {
		SquareSum ss = new SquareSum();
		System.out.println((ss.minSquareSum(14)).toString());
		System.out.println((ss.minSquareSum(50)).toString());
		System.out.println((ss.minSquareSumNum(14))); // 3
		System.out.println((ss.minSquareSumNum(50))); // 2
	}
}
