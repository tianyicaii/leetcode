#include <map>
#include <string>

std::string removeDuplicateLetters(std::string s) {

    if (s.empty()) return "";

    std::map<char, int> last_occurrence;
    for (int i = 0; i < s.size(); ++i) {
        last_occurrence[s[i]] = i;
    }

    char next_char = s[0];
    int next_pos = 0;
    for (int i = 0; ; ++i) {
        char c = s[i];
        if (c < next_char) {
            next_char = c;
            next_pos = i;
        }
        if (last_occurrence[c] == i) break;
    }

    std::string sub_seq;
    for (int i = next_pos + 1; i < s.size(); ++i) {
        char c = s[i];
        if (c != next_char) sub_seq.push_back(c);
    }
    return next_char + removeDuplicateLetters(sub_seq);
}
