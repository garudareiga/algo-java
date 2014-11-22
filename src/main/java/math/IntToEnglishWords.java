package math;

import java.util.*;
import com.google.common.base.Joiner;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * GIven an integer, print an english phrase that describes the integer
 * e.g
 * 1080 -> One Thousand Eighty
 */ 

public class IntToEnglishWords {
    private static String[] nums = {
        "",
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Tweleve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighten",
        "Ninteen",
    };
    
    private static String[] tenNums = {
        "",
        "Ten",
        "Twenty",
        "Thirty",
        "Fourty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninty"
    };
    
    private static String[] kNums = {
        "",
        "Thousand",
        "Million",
        "Billion"
    };
    
    public String convert(int value) {  
        ArrayList<String> result = new ArrayList<String>();
        int step = 0;
        while (value > 0) {
            result.add(convert_hundreds(value%1000) + " " + kNums[step++]);
            value /= 1000;
        }
              
        Collections.reverse(result);
        return Joiner.on(" ").join(result);
    }
    
    public String convert_hundreds(int value) {
        List<String> strs = new ArrayList<String>();
        if (value >= 100) {
            strs.add(nums[value/100] + " Hundred");
            value %= 100;
        }
        if (value >= 20) {
            strs.add(tenNums[value/10]);
            value %= 10;
        }
        if (value > 0)
            strs.add(nums[value]);
        return Joiner.on(" ").join(strs);
    }
    
    public static void main(String[] args) {
        IntToEnglishWords sol = new IntToEnglishWords();
        System.out.println(sol.convert(1123));
        System.out.println(sol.convert(99112999));
        System.out.println(sol.convert(1222111333));
    }
}
