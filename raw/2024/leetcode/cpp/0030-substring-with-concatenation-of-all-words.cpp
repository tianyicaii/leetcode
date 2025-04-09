#include <vector>
#include <string>
#include <map>


std::vector<int> find_window(std::map<std::string, int> & dict, std::string& s, std::string::iterator i, int word_len, int sub_str_len) {

    std::vector<int> ans;
    std::map<std::string, int> window;

    while (i + sub_str_len <= s.end()) {

        auto j = i;
        while(j + word_len <= s.end()) {
            std::string w(j, j + word_len);

            auto d_it = dict.find(w);
            if (d_it == dict.end()) {
                i = j + word_len;
                window.clear();
                break;
            }

            window[w] += 1;
            while (dict[w] < window[w]) {
                std::string w_left(i, i + word_len);
                window[w_left] -= 1;
                i += word_len;
            }

            j += word_len;
            if (j - i == sub_str_len) {
                ans.push_back(i - s.begin());
            } 
        }
    }
    return ans;
}


std::vector<int> findSubstring(std::string s, std::vector<std::string>& words) {

    if (words.empty()) { return {}; }

    std::map<std::string, int> dict;
    int word_len = words.front().size();
    int sub_str_len = 0;
    std::vector<int> ans;

    for (auto & w : words) {
        dict[w] += 1;
        sub_str_len += w.size();
    }

    for (int i = 0; i < word_len; i++) {
        auto sub_ans = find_window(dict, s, s.begin() + i, word_len, sub_str_len);
        ans.insert(ans.end(), sub_ans.begin(), sub_ans.end());
    }

    return ans;
}
