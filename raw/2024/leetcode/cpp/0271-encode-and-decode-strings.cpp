#include <cstdlib>
#include <vector>
#include <string>


class Codec {
public:

    // Encodes a list of strings to a single string.
    std::string encode(std::vector<std::string>& strs) {
        std::string ans;
        for (auto & s : strs) {
            ans.append(std::to_string(s.size()) + std::string(" ") + s);
        }
        return ans;
    }

    // Decodes a single string to a list of strings.
    std::vector<std::string> decode(std::string s) {
        std::vector<std::string> ans;
        int i = 0;
        while (i < s.size()) {
            int j = s.find(' ', i);
            std::string len_s = s.substr(i, j-i);
            int len = atoi(len_s.c_str());
            std::string seg = s.substr(j + 1, len);
            i = j + 1 + len;
            ans.push_back(seg);
        }
        return ans;
    }
};
