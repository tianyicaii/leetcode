#include <vector>

void swap(char & a, char & b) {
    char t = a;
    a = b;
    b = t;
}

void reverse(std::vector<char>::iterator b, std::vector<char>::iterator e) {
    while (b < e) {
        swap(*(b++), *(--e));
    }
}

void reverseWords(std::vector<char>& s) {
    reverse(s.begin(), s.end());

    for (auto i = s.begin(); i < s.end(); ) {
        auto j = i + 1;
        while (j != s.end() && *j != ' ') ++j;
        reverse(i, j);
        if (j == s.end()) return;
        i = j + 1;
    }
}
