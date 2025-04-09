#include <vector>
#include <string>


std::vector<std::string> A;
std::string I;


void find(std::vector<int> & path, int idx) {

    if (idx == I.size()) {
        if (path.size() == 4) {
            A.push_back(std::to_string(path[0]) + "." + std::to_string(path[1]) + "." + std::to_string(path[2]) + "." + std::to_string(path[3]));
        }
        return;
    }
    if (path.size() == 4) return;
    if (I[idx] == '0') {
        path.push_back(0);
        find(path, idx + 1);
        path.pop_back();
    }
    else {
        int v = 0;
        for (int i = 0; i < 3 && idx + i < I.size(); ++i) {
            v *= 10;
            v += (I[idx + i] - '0');
            if (v <= 255) {
                path.push_back(v);
                find(path, idx + i + 1);
                path.pop_back();
            }
        }
    }
}


std::vector<std::string> restoreIpAddresses(std::string s) {
    A.clear();
    I = s;
    std::vector<int> path;
    find(path, 0);
    return A;
}
