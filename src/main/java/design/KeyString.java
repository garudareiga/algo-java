package design;

import java.util.HashMap;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Check how to override equals and hashCode
 */ 

public class KeyString {
    String str;
    
    public KeyString(String str) {
        this.str = str;
    }
    
    @Override
    public boolean equals(Object o) {
        System.out.println(o.getClass().getName());
        if (o instanceof KeyString) {
            System.out.println("Type KeyString");
            KeyString ts = (KeyString)o;
            return this.str.equals(ts.str);
        } else if (o instanceof String) {
            System.out.println("Type String");
            String s = (String)o;
            return this.str.equals(s);
        }
        
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.str.hashCode();
    }
    
//    public static int hash(int h) {
//        h ^= (h >>> 20) ^ (h >>> 12);
//        return h ^ (h >>> 7) ^ (h >>> 4);
//    }
    
    public static void main(String[] args) {
        HashMap<KeyString, String> map = new HashMap<KeyString, String>();
        String key = "abc",
               value = "cba";
        KeyString testKeyStr = new KeyString(key);        
        map.put(testKeyStr, value);
        
        System.out.println("Get 1: ");
        System.out.println(map.get(testKeyStr));
        System.out.println("Get 2: ");
        System.out.println(map.get(new KeyString(key)));
        System.out.println("Get 3: ");
        System.out.println(testKeyStr.hashCode());
        System.out.println(key.hashCode());
        
        //int hash = KeyString.hash(key.hashCode());
        // not working ???
        System.out.println(map.get(key));
    }
}
