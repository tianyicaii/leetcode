#include <climits>
#include <vector>

bool increasingTriplet(std::vector<int>& nums) {

    int first = INT_MAX;
    int second = INT_MAX;
    for (int i : nums) {
        if (i < first) first = i;
        else if (i > first && i < second) second = i;
        else if (i > second) return true;
    }
    return false;
}