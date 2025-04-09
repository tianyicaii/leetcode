#include <vector>

int hIndex(std::vector<int>& citations) {

    // search on H value
    int left = 0;
    int right = citations.size() + 1;

    while (left < right - 1) {

        int mid = left + (right - left) / 2;

        if (citations[citations.size() - mid] >= mid) left = mid;
        else right = mid;

    }

    return left;
}

