#include <set>
#include <vector>

bool containsDuplicate(std::vector<int>& nums) {

    std::set<int> seen;
    for (int i : nums) {
        if (seen.count(i)) return true;
        seen.insert(i);
    }
    return false;
}