#include <string>

std::string addBinary(std::string a, std::string b) {

    std::string ans;

    auto i = a.rbegin();
    auto j = b.rbegin();
    int c = 0;
    while (i != a.rend() || j != b.rend()) {

        int va = (i == a.rend()) ? 0 : *i++ - '0';
        int vb = (j == b.rend()) ? 0 : *j++ - '0';
        int sum = va + vb + c;
        ans.push_back(sum % 2 + '0');
        c = sum / 2;
    }
    if (c) { ans.push_back('1'); }
    return std::string(ans.rbegin(), ans.rend());
}
