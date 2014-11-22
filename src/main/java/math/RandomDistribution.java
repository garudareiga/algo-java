package math;

import java.util.*;

import org.apache.commons.math3.distribution.*;
import org.apache.commons.math3.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given an array a = ['x', 'b', ..., 'c'] of n chars, and b = [0.1, 0.2, ..., 0.01] 
 * of true probability. Write a random generator that generates the chars according to 
 * the probability.
 */

public class RandomDistribution {
    private EnumeratedDistribution<Character> distribution = null;
    
    public RandomDistribution() {}
    
    public RandomDistribution(final char[] charsToGenerate, final double[] discreteProbabilities) {
        
        final List<Pair<Character, Double>> samples = 
                new ArrayList<Pair<Character, Double>>(charsToGenerate.length);
        for (int i = 0; i < charsToGenerate.length; i++) {
            samples.add(new Pair<Character, Double>(charsToGenerate[i], discreteProbabilities[i]));
        }
        distribution = new EnumeratedDistribution<Character>(samples);
        
        // Use EnumeratedIntegerDistribution
//      int[] numbersToGenerate = new int[charsToGenerate.length];
//      for (int i = 0; i < charsToGenerate.length; i++)
//          numbersToGenerate[i] = (int)charsToGenerate[i];
//      
//      EnumeratedIntegerDistribution distribution =
//           new EnumeratedIntegerDistribution(numbersToGenerate, discreteProbabilities);
//      int sample = distribution.sample();
    }
    
	public char generate() {
	    return distribution.sample();	
	}
	
	public char generateNative(final char[] charsToGenerate, final double[] discreteProbabilities) {
	    Random random = new Random();
	    final double randomValue = random.nextDouble();
	    double sum = 0;
	    for (int i = 0; i < discreteProbabilities.length; i++) {
	        sum += discreteProbabilities[i];
	        if (randomValue < sum)
	            return charsToGenerate[i];
	    }
	    return charsToGenerate[charsToGenerate.length - 1];
	}
	
	public static void main(String[] args) {
	    char[] charsToGenerate = {'a', 'b', 'c', 'd', 'e'};
	    double[] discreteProbabilities = {0.1, 0.2, 0.4, 0.2, 0.1};  
	    RandomDistribution rd = new RandomDistribution(charsToGenerate, discreteProbabilities);
	    for (int i = 0; i < 20; i++)
	        System.out.println(i + ": " + rd.generate());
	}
}
