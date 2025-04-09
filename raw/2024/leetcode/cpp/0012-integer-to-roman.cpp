#include <iterator>
#include <string>

std::string intToRoman(int num) {

    int units[]           {1000, 900 , 500, 400 , 100, 90  , 50 , 40  , 10 , 9   , 5  , 4   , 1   };
    const char * digits[] {"M" , "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    std::string ans;

    auto u_it = std::begin(units);
    auto d_it = std::begin(digits);


    while (u_it != std::end(units)) {
        while (num >= *u_it) {
            ans.append(*d_it);
            num -= *u_it;
        }
        u_it++;
        d_it++;
    }
    return ans;
}

