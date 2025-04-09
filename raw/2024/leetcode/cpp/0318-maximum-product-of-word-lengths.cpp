#include <algorithm>
#include <vector>
#include <string>


int get_key(const std::string & word) {
    int key = 0;
    for (char c : word) {
        key |= (1 << (c - 'a'));
    }
    return key;
}


int maxProduct(std::vector<std::string>& words) {

    int ans = 0;

    for (int i = 0; i < words.size(); ++i) {
        for (int j = i + 1; j < words.size(); ++j) {
            int i_k = get_key(words[i]);
            int j_k = get_key(words[j]);
            if ((i_k & j_k) == 0) {
                ans = std::max(ans, (int)(words[i].size() * words[j].size()));
            }
        }
    }

    return ans;
}
