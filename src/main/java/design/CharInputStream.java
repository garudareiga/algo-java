package design;

import java.io.*;

public class CharInputStream {
    private final byte[] buffer;
    private final InputStream is;
    private int size;
    private int index;
    
    CharInputStream(InputStream is) {
        buffer = new byte[20];
        this.is = is;
        size = 0;
        index = 0;
    }
    
    /*
     * Implement read() function, return a valid char
     * if read() is called, otherwise return -1.
     */
    public int read() throws IOException {
        if (index == size) {
            index = 0;
            size = is.read(buffer);
        }
        // size = -1 if there is no more data because the end of the file has been reached.
        return size < 0 ? -1 : (char) buffer[index++];        
    }
    
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("/Users/lchen16/tmp.txt");
            System.out.println("Total file size (in bytes): " + is.available());
            CharInputStream cis = new CharInputStream(is);
            int r = 0;
            while (true) {
                r = cis.read();
                if (r == -1) break;
                System.out.print((char) r);
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
