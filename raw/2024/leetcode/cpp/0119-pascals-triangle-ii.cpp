#include <vector>

std::vector<int> getRow(int rowIndex) {

    std::vector<std::vector<int>> ans;

    for (int i = 0; i <= rowIndex; ++i) {
        if (i == 0) ans.push_back({1});
        else {
            std::vector<int> lev;
            const std::vector<int> & prev = ans.back();
            for (int j = 0; j <= prev.size(); ++j) {
                if (j == 0) lev.push_back(1);
                else if (j == prev.size()) lev.push_back(1);
                else {
                    lev.push_back(prev[j-1] + prev[j]);
                }
            }
            ans.push_back(lev);
        }
    }

    return ans[rowIndex];
}
