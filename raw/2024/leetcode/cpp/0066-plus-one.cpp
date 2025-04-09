#include <vector>

std::vector<int> plusOne(std::vector<int>& digits) {

    int carry = 1;
    for (auto it = digits.rbegin(); it != digits.rend(); ++it) {
        int sum = *it + carry;
        *it = sum % 10;
        carry = sum / 10;
    }
    if (carry) { digits.insert(digits.begin(), 1); }
    return digits;
};
