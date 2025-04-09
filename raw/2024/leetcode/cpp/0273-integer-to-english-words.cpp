#include <string>
#include <vector>


std::vector<std::string> less_than_20 = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
};

std::vector<std::string> less_than_100 = {
        "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
};

std::vector<std::string> units = {
        "", "Thousand", "Million", "Billion"
};


std::vector<std::string> helper(int num) {
    std::vector<std::string> ans;
    if (num / 100) {
        ans.push_back(less_than_20[num / 100]);
        ans.push_back("Hundred");
        num %= 100;
    }
    if (num / 10 >= 2) {
        ans.push_back(less_than_100[num / 10]);
        num %= 10;
    }
    if (num > 0) {
        ans.push_back(less_than_20[num]);
    }
    return ans;
}


std::string numberToWords(int num) {
    std::vector<std::string> ans;
    int i = 0;
    while (num) {
        if (num % 1000) {
            std::vector<std::string> sub = helper(num % 1000);
            sub.push_back(units[i]);
            sub.insert(sub.end(), ans.begin(), ans.end());
            ans = sub;
        }
        ++i;
        num /= 1000;
    }

    if (ans.empty()) return "Zero";
    std::string str;
    str.append(ans[0]);
    for (int i = 1; i < ans.size(); ++i) {
        if (ans[i].empty()) continue;  // avoid ""
        str.push_back(' ');
        str.append(ans[i]);
    }
    return str;
}
