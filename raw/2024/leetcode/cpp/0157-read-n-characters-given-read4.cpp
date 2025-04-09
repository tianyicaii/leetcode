

#include <algorithm>
extern int read4(char *buf4);

class Solution {
public:
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */


    int read(char *buf, int n) {

        char b[4];
        char *p = buf;
        int cnt = 0;
        bool eof = false;

        while (cnt < n && !eof) {

            int read_len = read4(b);
            if (read_len < 4) eof = true;

            int len = std::min(read_len, n - cnt);
            for (int i = 0; i < len; ++i) {
                *p++ = *(b + i);
            }
            cnt += len;

        }

        return p - buf;
    }


};