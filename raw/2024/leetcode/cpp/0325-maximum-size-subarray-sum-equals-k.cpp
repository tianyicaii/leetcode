#include <map>
#include <vector>

int maxSubArrayLen(std::vector<int>& nums, int k) {

    int ans = 0;

    std::map<long long, int> prefix;
    prefix[0] = 0;
    long long sum = 0;
    for (int i = 0; i < nums.size(); ++i) {
        sum += nums[i];
        int len = i + 1;
        long long need = sum - k;
        if (prefix.count(need)) { ans = std::max(len - prefix[need], ans); }
        if (!prefix.count(sum)) prefix[sum] = len;
    }


    return ans;

}