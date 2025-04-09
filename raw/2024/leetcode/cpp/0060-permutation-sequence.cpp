#include <string>
#include <vector>

std::string getPermutation(int n, int k) {

    std::string ans;

    std::vector<unsigned long long> fact(n+1, 1);
    for (int i = 1; i <= n; ++i) {
        fact[i] = i * fact[i-1];
    }
    std::vector<bool> used(n+1, false);

    k -= 1;

    for (int i = n; i >= 1; --i) {
        int cnt = k / fact[i-1];
        k %= fact[i-1];

        for (int d = 1; d <=n; ++d) {
            if (used[d]) { continue; }
            if (cnt == 0) {
                ans.push_back(d + '0');
                used[d] = true;
                break;
            }
            --cnt;
        }
    }
    return ans;
}