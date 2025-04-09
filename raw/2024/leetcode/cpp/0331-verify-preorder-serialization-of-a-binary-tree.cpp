#include <string>


bool isValidSerialization(std::string preorder) {

    int slot = 1;
    int i = 0;
    while (i < preorder.size()) {
        int j = preorder.find(",", i);
        std::string token;
        if (j == -1) {
            token = preorder.substr(i, preorder.size() - i);
            i = preorder.size();
        } else {
            token = preorder.substr(i, j);
            i = j + 1;
        }
        if (slot == 0) return false;
        if (token == "#") slot -= 1;
        else slot += 1;

    }
    return slot == 0;
}
