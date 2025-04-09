#include <cmath>
#include <cstdlib>
#include <string>

int countDigitOne(int n) {

    std::string N = std::to_string(n);
    int ans = 0;
    for (int i = 0; i < N.size(); ++i) {

        int prev = (i == 0) ? 0 : atoi(N.substr(0, i).c_str());
        int suff = (i == N.size()) ? 0 : atoi(N.substr(i + 1).c_str());

        char c = N[i];
        int cnt = pow(10, N.size() - i - 1);

        if (c == '0') {
            ans += prev * cnt;
        } else if (c == '1') {
            ans += prev * cnt;
            ans += suff + 1;
        } else {
            ans += (prev + 1) * cnt;
        }
    }
    return ans;

}