#include <algorithm>
#include <map>
#include <vector>


class UF {

private:
    int N;
    std::vector<int> p;
    std::vector<int> c;
public:
    UF(int n): N(n), p(n), c(n) {
        for (int i = 0; i < N; ++i) {
            c[i] = 1;
            p[i] = i;
        }
    }

    void u(int i, int j) {
        int p_i = f(i);
        int p_j = f(j);
        if (p_i == p_j) return;
        c[p_i] += c[p_j];
        p[p_j] = p_i;
    }

    int f(int i) {
        while (p[i] != i) {
            p[i] = p[p[i]];
            i = p[i];
        }
        return i;
    }

    int cnt(int i) {
        return c[f(i)];
    }

    int find_max() {
        int m = 0;
        for (int i = 0; i < N; ++i) {
            m = std::max(m, cnt(i));
        }
        return m;
    }
};

int longestConsecutive(std::vector<int>& nums) {

    int N = nums.size();
    UF uf(N);

    std::map<int, int> v_2_i;

    for (int i = 0; i < N; ++i) {
        v_2_i.insert({nums[i], i});
    }

    for (int v : nums) {
        int i = v_2_i[v];
        auto it = v_2_i.find(v + 1);
        if (it != v_2_i.end()) uf.u(i, it->second);
        it = v_2_i.find(v - 1);
        if (it != v_2_i.end()) uf.u(i, it->second);
    }

    return uf.find_max();
}
