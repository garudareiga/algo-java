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
    private int start = 0, end = 0, offset = 0;
    private byte[] buffer = new byte[4*1024];
    
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
                if (end == 0) break;
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
                    if (end == 0) break; // EOF
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
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (start == end) { // buffer is empty
                start = 0; end = read4K(buffer);                
                if (end == -1) {
                    if (sb.length() == 0) return null; // EOF
                    else break;
                }
                //System.out.println(new String(buffer));
            } else {
                sb.append((char)buffer[start++]);
                if (buffer[start - 1] == '\n') return sb.toString();
            }
        }
        return sb.toString(); // EOF
    }
    
    public void print() {
        System.out.println("start=" + start + ", end=" + end);
    }
    
    private int read4K(byte[] buffer) {
        try {
            int size = is.read(buffer, this.offset, 1024);
            this.offset += size;
            return size;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    private int read4K(byte[] buffer, int offset) {
        try {
            return is.read(buffer, offset, 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
        
    public static void main(String[] args) {
        File file = new File("/Users/raychen/tmp.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            Reader reader = new Reader(fis);
            for (int i = 1; i <= 20; i++) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.print(i + " : " + line);
                //reader.print();
            }
            System.out.println("END");
            fis.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
