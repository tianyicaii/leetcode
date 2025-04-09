#include <deque>
#include <string>


std::string simplifyPath(std::string path) {

    path.push_back('/');  // to pop last section

    std::deque<std::string> p;
    std::string v;

    for (auto c : path) {
        if (c == '/') {
            if (!v.empty()) {
                if (v.empty()) {
                    ;
                } else if (v == ".") {
                    ;
                } else if (v == "..") {
                    if (p.empty()) {
                        ;
                    } else {
                        p.pop_back();
                    }
                } else {
                    p.push_back(v);
                }
                v.clear();
            }
        } else {
            v.push_back(c);
        }
    }

    if (p.empty()) { return "/"; }

    std::string ans;
    while (!p.empty()) {
        ans.push_back('/');
        ans.append(p.front());
        p.pop_front();
    }
    return ans;
}
