// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/


public class Solution {
	

	char[] buf4 = new char[4];
	int sz = 0;
	int ptrBuf4 = 0;
	boolean eof = false;

    public int read(char[] buf, int n) {
    	
        int ptrBuf  = 0;
        
        while (n > 0) {
        	
        	if (sz == 0) {
        		if (eof) break;
        		sz = read4(buf4);
        		ptrBuf4 = 0;
        		if (sz < 4) eof = true;
        		
        	}
        	int len = Math.min(sz, n);
        	for (int i = 0; i < len; i++) {
        		buf[ptrBuf++] = buf4[ptrBuf4++];
        	}
        	n  -= len;
        	sz -= len;
        }
        
        return ptrBuf;
    }


}

