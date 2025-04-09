#include <vector>



int N;
std::vector<int> ans;


void flip(int & i, int d) {
    i ^= 1 << d;
}


void find(int & path, int d) {
    if (d == N) {
        ans.push_back(path);
        return;
    }
    find(path, d + 1);
    flip(path, d);
    find(path, d + 1);
}

std::vector<int> grayCode(int n) {
    ans.clear();
    N = n;
    int path = 0;
    find(path, 0);
    return ans;
}
