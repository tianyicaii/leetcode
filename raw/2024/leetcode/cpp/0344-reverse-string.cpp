#include <vector>

void reverseString(std::vector<char>& s) {
    int i = 0;
    int j = s.size() - 1;
    while (i < j) {
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
        ++i;
        --j;
    }
}
