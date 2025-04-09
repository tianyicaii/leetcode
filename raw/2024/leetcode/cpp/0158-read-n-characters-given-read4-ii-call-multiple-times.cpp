#include <algorithm>
#include <cassert>

extern int read4(char *buf4);

class Solution {
public:
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    char b[4];
    int offset = 0;
    int sz = 0;
    bool eof = false;

    bool empty() { return offset == sz; }

    int move(char * p, int n) {
        int remain_len = sz - offset;
        int len = std::min(n, remain_len);
        for (int i = 0; i < len; ++i) {
            *p++ = b[offset++];
        }
        return len;
    }

    void load() {
        assert(offset == sz);
        assert(!eof);
        offset = 0;
        int read_len = read4(b);
        if (read_len < 4) eof = true;
        sz = read_len;
    }

    int read(char *buf, int n) {

        char * p = buf;
        int cnt = 0;

        while (true) {
            int c = move(p, n - cnt);
            p += c;
            cnt += c;
            if (cnt == n) break;
            if (eof) break;
            load();
        }

        return p - buf;
    }
};

