package design;

import java.io.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given read4K function, implement readAny function which read any bytes
 */ 

public class Reader {
    private InputStream is = null;
    private int start = 0, end = 0;
    private byte[] buffer = new byte[4*1024];
    private boolean endOfFile = false;
    
    public Reader(InputStream is) {
        this.is = is;
    }
    
    /*
     * Read N bytes
     */
    public int read(char[] array, int N) {
        int p = 0;
        while (N > 0) {
            if (start == end) { // buffer is empty
                start = 0; end = read4K(buffer);
                if (end == -1) break;
            }
            int copySize = Math.min(N, end - start);
            System.arraycopy(buffer, start, array, p, copySize);
            start += copySize;
            p += copySize;
            N -= copySize;
        }
        return p;
    }
    
    /*
     * Read N bytes optimized for large file
     */
    public int readOptimized(char[] array, int N) {
        int p = 0;
        while (N > 0) {
            if (start == end) { // buffer is empty
                if (N > 4*1024) {
                    // copy directly to array instead of buffer to save memory
                    int copySize = read(array, p); 
                    p += copySize;
                    N -= copySize;
                    if (copySize < 4*1024) break; // EOF
                } else {
                    start = 0; end = read4K(buffer, 0);
                    if (end == -1) break; // EOF
                }
            } else {
                int copySize = Math.min(N, end - start);
                System.arraycopy(buffer, start, array, p, copySize);
                start += copySize;
                p += copySize;
                N -= copySize;
            }
        }
        return p;
    }
    
    public String readLine() {
        if (endOfFile) return null;
        StringBuilder sb = new StringBuilder();
        while (!endOfFile) {
            if (start == end) { // buffer is empty
                start = 0; end = read4K(buffer);   
                if (end == -1) endOfFile = true;
            } else {
                char c = (char)buffer[start++];
                sb.append(c);
                if (c == '\n') break;
            }
        }
        return sb.toString(); // EOF
    }
    
    private int read4K(byte[] buffer) {
        return read4K(buffer, 0);
    }
    
    public int read4K(byte[] buffer, int offset) {
        try {
            return is.read(buffer, offset, 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
        
    public static void main(String[] args) {
        File file = new File("/Users/lchen16/Spurs.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            Reader reader = new Reader(fis);
            
            for (int i = 1; i <= 20; i++) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.println(i + " : " + line);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
