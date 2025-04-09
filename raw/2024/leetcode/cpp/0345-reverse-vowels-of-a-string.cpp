#include <string>


bool is_vowel(char c) {
    static std::string vowels("aeiouAEIOU");
    return vowels.find(c) != -1;
}


void swap(std::string::iterator a, std::string::iterator b) {
    char c = *a;
    *a = *b;
    *b = c;
}


std::string reverseVowels(std::string s) {
    if (s.empty()) return s;

    auto a = s.begin();
    auto b = s.end() - 1;

    while (true) {
        while (a < b && !is_vowel(*a)) ++a;
        while (a < b && !is_vowel(*b)) --b;
        if (a >= b) break;
        swap(a++, b--);
    }

    return s;
}
