#include <vector>

int countPrimes(int n) {

    std::vector<bool> is_prime(n + 1, true);

    for (int i = 2; i * i < n; ++i) {

        if (!is_prime[i]) continue;

        for (int j = 2; i * j < n; ++j) {
            is_prime[i * j] = false;
        }
    }

    int ans = 0;
    for (int i = 2; i < n; ++i) {
        if (is_prime[i]) ans += 1;
    }
    return ans;
}
