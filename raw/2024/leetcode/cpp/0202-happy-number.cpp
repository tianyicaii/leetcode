#include <set>


int get_next(int n) {
    int ans = 0;
    
    while (n != 0) {
        int d = n % 10;
        n /= 10;
        ans += d * d;
    }
    return ans;
}


bool isHappy(int n) {

    std::set<int> seen;

    while (true) {

        if (n == 1) return true;
        if (seen.count(n)) return false;
        seen.insert(n);
        n = get_next(n);
    }
}
