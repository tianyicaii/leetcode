#include <map>
#include <set>
#include <string>
#include <vector>


class ValidWordAbbr {

    std::map<std::string, std::set<std::string>> dict;

    std::string get_abbr(const std::string & s) {
        if (s.size() <= 2) {
            return s;
        }
        return std::string() + s[0] + std::to_string(s.size()) + s[s.size() - 1];
    }

public:

    ValidWordAbbr(std::vector<std::string>& dictionary) {
        for (const auto & s : dictionary) {
            dict[get_abbr(s)].insert(s);
        }
    }
    
    bool isUnique(std::string word) {
        std::string key = get_abbr(word);

        auto it = dict.find(key);
        if (it == dict.end()) {
            return true;
        }
        if (it->second.size() >= 2) return false;
        return *(it->second.begin()) == word;
    }
};
