#include <algorithm>
#include <queue>
#include <vector>

int numSquares(int n) {

    std::vector<int> dp(n+1);
    for (int i = 0; i <= n; ++i) {
        dp[i] = i;
    }
    for (int i = 0; i <= n; ++i) {
        if (i == 0) dp[i] = 0;
        else {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = std::min(dp[i], dp[i - j * j] + 1);
            }
        }
    }
    return dp[n];
}


int numSquares_(int n) {

    if (n == 0) return 0;

    std::vector<int> edges;
    for (int i = 1; i * i <= n; ++i) {
        edges.push_back(i*i);
    }
    std::vector<bool> visited(n+1);
    visited[0] = true;
    int depth = 0;
    std::queue<int> q;
    q.push(0);

    while (!q.empty()) {

        int sz = q.size();
        for (int i = 0; i < sz; ++i) {
            int v = q.front();
            q.pop();
            for (int e : edges) {
                int x = v + e;
                if (x > n) continue;
                if (x == n) return depth + 1;
                if (visited[x]) continue;
                visited[x] = true;
                q.push(x);
            }
        }
        depth += 1;

    }
    return -1;
}
