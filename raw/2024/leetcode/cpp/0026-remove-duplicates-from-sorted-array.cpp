#include <vector>

int removeDuplicates(std::vector<int>& nums) {

    if (nums.size() < 1) { return 0; }
    auto last_uniq_val = nums.begin();

    for (auto curr = nums.begin() + 1; curr != nums.end(); ++curr) {
        if (*curr == *last_uniq_val) { continue; }
        *(++last_uniq_val) = *curr;
    }

    return last_uniq_val - nums.begin() + 1;
}
