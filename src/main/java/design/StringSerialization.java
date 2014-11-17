package design;

import java.io.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * String serialize(String[] a)
 * String[] deserialize(String b);
 */ 

public class StringSerialization {
    String serialize(String[] strs) {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(strs);
            return bos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    String[] deserialize(String str) {
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(str.getBytes());
            ois = new ObjectInputStream(bis);
            Object o = ois.readObject();
            return (String[])o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        String[] strs = {"a", "b"};
        StringSerialization sol = new StringSerialization();
        
        String serializedStr = sol.serialize(strs);
        String[] deserializedStrs = sol.deserialize(serializedStr);
        
        System.out.println("Serilization: " + serializedStr);
        System.out.println("Deserialization:");
        for (String str : deserializedStrs)
            System.out.println(str);
    }
}
