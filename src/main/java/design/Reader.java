package design;

import java.io.*;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * int Read4K(char[] buf);
 * 
 * Given a read4K function, implement readAny function which read any bytes.
 */ 

public class Reader {
    //final private int BUFFER_SIZE = 4096;
    final private int BUFFER_SIZE = 4; // for testing
    private InputStream is = null;
    private int offset = 0;
    private int size = 0;
    private byte[] buffer = new byte[BUFFER_SIZE];
    private boolean endOfFile = false;
    
    public Reader(InputStream is) {
        this.is = is;
    }
    
    /*
     * Read N bytes
     */
    public int read(byte[] array, int N) {
        int readBytes = 0;
        while ((!endOfFile || size - offset > 0) && readBytes < N) {
            if (offset == size) { // check if empty buffer
                offset = 0;
                size = read4K(buffer);
                if (size < BUFFER_SIZE) { endOfFile = true; }
            }
            int bytes = Math.min(N - readBytes, size - offset);
            if (bytes > 0) {
                System.arraycopy(buffer, offset, array, readBytes, bytes);
                offset = offset + bytes;
                readBytes += bytes;
            }
        }
        return readBytes;
    }
    
    /*
     * Read N bytes optimized for large file
     */
    public int readOptimized(byte[] array, int N) {
        int readBytes = 0;
        while ((!endOfFile || size - offset > 0) && readBytes < N) {
            if (offset == size) { // buffer is empty
                if (N > BUFFER_SIZE) {
                    // copy directly to array instead of buffer to save memory
                    int types = read(array, readBytes); 
                    if (types < BUFFER_SIZE) { endOfFile = true; } // EOF
                    if (types > 0)
                        readBytes += types;
                } else {
                    offset = 0; size = read4K(buffer);
                    if (size < BUFFER_SIZE) { endOfFile = true; } // EOF
                }
            } else {
                int bytes = Math.min(N - readBytes, size - offset);
                if (bytes > 0) {
                    System.arraycopy(buffer, bytes, array, readBytes, bytes);
                    readBytes += bytes;
                }
            }
        }
        return readBytes;
    }
    
    public String readLine() {
        int readBytes = 0;
        StringBuilder sb = new StringBuilder();
        while (!endOfFile) {
            if (offset == size) { // buffer is empty
                offset = 0; size = read4K(buffer);   
                if (size == -1) {
                    endOfFile = true;
                }
            } else {
                char c = (char)buffer[offset++];
                sb.append(c);
                readBytes++;
                if (c == '\n') break;
            }
        }
        return readBytes == 0 ? null : sb.toString(); // EOF
    }
    
    private int read4K(byte[] buffer) {
        return read4K(buffer, 0);
    }
    
    public int read4K(byte[] buffer, int offset) {
        try {
            return is.read(buffer, offset, BUFFER_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
        
    public static void main(String[] args) {
        File file = new File(args[0]);
        { // Testing read() function
            try {
                System.out.println("Test read() ->");
                FileInputStream fis = new FileInputStream(file);
                Reader reader = new Reader(fis);
                
                final int SIZE = 3;
                //final int SIZE = 5;
                byte[] buf = new byte[SIZE];
                for (int i = 1; i <= 20; i++) {
                    int bytes = reader.read(buf, SIZE);
                    if (bytes == 0) break;
                    System.out.println(i + " : " + new String(buf));
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        { // Testing readLine() function
            try {
                System.out.println("Test readLine() ->");
                FileInputStream fis = new FileInputStream(file);
                Reader reader = new Reader(fis);
                
                for (int i = 1; i <= 20; i++) {
                    String line = reader.readLine();
                    if (line == null) break;
                    System.out.print(i + " : " + line);
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
