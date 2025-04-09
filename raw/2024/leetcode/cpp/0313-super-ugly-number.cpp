#include <functional>
#include <queue>
#include <vector>


struct Factor {

    int prime;
    int index;
    unsigned long long candidate;

    Factor(int p) : prime(p), index(0), candidate(p) {}

    bool operator<(const Factor & other) const {
        return candidate < other.candidate;
    }

};


int nthSuperUglyNumber(int n, std::vector<int> & primes) {

    std::priority_queue<Factor, std::vector<Factor>, std::function<bool(const Factor &, const Factor &)>> candidates(
        [](const Factor & a, const Factor & b) { return b < a; }
    );
    for (int p : primes) {
        candidates.push(Factor(p));
    }
    std::vector<unsigned long long> ugly_nums{1};
    while (ugly_nums.size() < n) {
        Factor x = candidates.top();
        candidates.pop();
        if (x.candidate > ugly_nums.back()) {
            ugly_nums.push_back(x.candidate);
        }
        x.index += 1;
        x.candidate = x.prime * ugly_nums[x.index];
        candidates.push(x);
    }
    return ugly_nums[n-1];
}

