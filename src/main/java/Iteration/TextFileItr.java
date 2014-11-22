package Iteration;

import java.io.*;
import java.util.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Implement a text file iterator
 */

public class TextFileItr implements Iterator<String> {
    final BufferedReader br;
    String nextLine = null;
    
    public TextFileItr(String fname) throws FileNotFoundException {
        try {
            br = new BufferedReader(new FileReader(fname));
            nextLine = br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
    
    public boolean hasNext() {
        return nextLine != null;
    }

    public String next() {
        if (!hasNext())
            throw new IllegalArgumentException();
        try {
            String r = nextLine;
            if (nextLine != null) {
                nextLine = br.readLine();
                if (nextLine == null)
                        br.close();
            }
            return r;
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public void remove() {
    }
    
    public static void main(String[] args) {
        try {
            String fname = args[0];
            System.out.println("Open file " + fname);
            TextFileItr itr = new TextFileItr(fname);
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
