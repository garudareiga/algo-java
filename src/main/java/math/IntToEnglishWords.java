package math;

import java.util.ArrayList;
import java.util.Collections;

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
        "Zero",
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
              
        StringBuilder sb = new StringBuilder();
        Collections.reverse(result);
        for (String str : result)
            sb.append(str + " ");
        return sb.toString();
    }
    
    public String convert_hundreds(int value) {
        StringBuilder sb = new StringBuilder();
        if (value >= 100) {
            sb.append(nums[value/100] + " Hundred ");
            value %= 100;
        }
        if (value >= 20) {
            sb.append(tenNums[value/10] + " ");
            value %= 10;
        }
        if (value > 0)
            sb.append(nums[value]);
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
        IntToEnglishWords sol = new IntToEnglishWords();
        System.out.println(sol.convert(1123));
        System.out.println(sol.convert(99112999));
        System.out.println(sol.convert(1222111333));
    }
}
