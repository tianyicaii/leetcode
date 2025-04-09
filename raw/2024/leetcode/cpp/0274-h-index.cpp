#include <vector>

int hIndex(std::vector<int>& citations) {

    int N = citations.size();
    std::vector<int> cnts(N + 1);
    for (int c : citations) {
        int i = std::min(N, c);
        cnts[i] += 1;
    }

    int h = N;
    int n_papers = cnts[h];
    while (h > 0 && h > n_papers) {
        n_papers += cnts[--h];
    }
    return h;
}

