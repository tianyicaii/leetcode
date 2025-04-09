#include <map>
#include <string>


std::map<std::string, bool> mem;

bool canWin(std::string currentState) {

    if (mem.count(currentState)) {
        return mem[currentState];
    }

    bool can_win = false;

    int i = 1;
    while (i < currentState.size()) {
        if (currentState[i-1] == currentState[i] && currentState[i] == '+') break;
        ++i;
    }
    if (i >= currentState.size()) return false;


    for (; i < currentState.size(); ++i) {
        if (currentState[i-1] == currentState[i] && currentState[i] == '+') {

            std::string next = currentState;
            next[i-1] = next[i] = '-';
            if (!canWin(next)) {
                can_win = true;
                break;
            }
        }
    }

    mem[currentState] = can_win;
    return can_win;
}
