#include <numeric>
#include <vector>


int candy(std::vector<int>& ratings) {

    std::vector<int> c(ratings.size(), 1); 


    for (int i = 1; i < ratings.size(); ++i) {
        if (ratings[i] > ratings[i-1]) c[i] = c[i-1] + 1;
    }
    for (int i = ratings.size() - 2; i >= 0; --i) {
        if (ratings[i] > ratings[i+1] && c[i] <= c[i + 1]) c[i] = c[i+1] + 1;
    }

    return std::accumulate(c.begin(), c.end(), 0);
}
