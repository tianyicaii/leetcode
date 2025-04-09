#include <string>



bool is_valid(const std::string & num, unsigned long long x, unsigned long long y, int i) {

    do {
        unsigned long long sum = x + y;
        std::string num3 = std::to_string(sum);
        if (num.find(num3, i) != i) return false;
        x = y;
        y = sum;
        i += num3.size();
    } while (i != num.size());
    return true;
}



bool isAdditiveNumber(std::string num) {

    for (int i = 1; i <= num.size() / 2; ++i) {
        for (int j = 1; i + j < num.size() && j <= num.size() / 2; ++j) {
            std::string num1 = num.substr(0, i);
            std::string num2 = num.substr(i, j);
            if (num1.size() > 1 && num1[0] == '0') continue;
            if (num2.size() > 1 && num2[0] == '0') continue;
            unsigned long long x = std::stoull(num1);
            unsigned long long y = std::stoull(num2);
            if (is_valid(num, x, y, i+j)) return true;
        }
    }
    return false;
}
