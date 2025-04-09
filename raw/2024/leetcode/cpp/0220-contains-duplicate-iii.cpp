#include <cstdlib>
#include <map>
#include <set>
#include <vector>

bool containsNearbyAlmostDuplicate_(std::vector<int>& nums, int indexDiff, int valueDiff) {

    std::set<int> seen;

    for (int i = 0; i < nums.size(); ++i) {

        int v = nums[i];
        if (seen.count(v)) return true;

        seen.insert(v);
        auto it = seen.find(v);
        if (it != seen.begin()) {
            --it;
            if (std::abs(*it - v) <= valueDiff) return true;
        }

        it = seen.find(v);
        ++it;
        if (it != seen.end()) {
            if (std::abs(*it - v) <= valueDiff) return true;
        }

        if (seen.size() == indexDiff + 1) {
            seen.erase(nums[i - indexDiff]);
        }
    }
    return false;
}


// bucket sort

int get_index(int v, int bucket_size) {
    if (v >= 0) return v / bucket_size;
    return - ((-1 - v) / bucket_size + 1);
}

bool containsNearbyAlmostDuplicate(std::vector<int>& nums, int indexDiff, int valueDiff) {
    int bucket_size = 1;
    if (valueDiff != 0) bucket_size = valueDiff; 
    std::map<int, int> buckets;

    for (int i = 0; i < nums.size(); ++i) {
        int v = nums[i];
        int idx = get_index(v, bucket_size);
        if (buckets.count(idx)) return true;
        if (buckets.count(idx + 1) && std::abs(buckets[idx + 1] - v) <= valueDiff) return true;
        if (buckets.count(idx - 1) && std::abs(buckets[idx - 1] - v) <= valueDiff) return true;
        buckets.insert({idx, v});
        if (buckets.size() == indexDiff + 1) { buckets.erase(get_index(nums[i-indexDiff], bucket_size)); }
    }

    return false;
}
