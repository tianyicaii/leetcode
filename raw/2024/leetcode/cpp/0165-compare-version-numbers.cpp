#include <sstream>
#include <string>
#include <vector>

std::vector<int> get(const std::string & v) {

    std::vector<int> ans;
    std::istringstream vs(v);

    int i;
    char dot;
    vs >> i;
    ans.push_back(i);

    while (vs >> dot) {
        vs >> i;
        ans.push_back(i);
    }
    return ans;
}

int compareVersion(std::string version1, std::string version2) {

    std::vector<int> v1 = get(version1);
    std::vector<int> v2 = get(version2);

    int i = 0;
    for (; i < v1.size() || i < v2.size(); ++i) {

        int a = (i >= v1.size()) ? 0 : v1[i];
        int b = (i >= v2.size()) ? 0 : v2[i];

        if (a == b) continue;
        if (a < b) return -1;
        return 1;
    }
    return 0;
}
