#include <vector>
#include <string>


std::string flip(const std::string & s, int i) {
    std::string ans = s;
    ans[i] = ans[i+1] = '-'; 
    return ans;
}


std::vector<std::string> generatePossibleNextMoves(std::string currentState) {
    std::vector<std::string> ans;
    for (int i = 0; i < currentState.size() - 1; ++i) {
        if (currentState[i] == currentState[i+1] && currentState[i] == '+') ans.push_back(flip(currentState, i));
    }
    return ans;
}
