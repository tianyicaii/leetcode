#include <string>
#include <vector>

std::string getHint(std::string secret, std::string guess) {

    int bulls = 0;
    int cows = 0;
    std::vector<int> cnt(10);

    for (int i = 0; i < secret.size(); ++i) {
        char s = secret[i];
        char g = guess[i];
        if (s == g) bulls += 1;
        else {
            cnt[s-'0'] += 1;
            cnt[g-'0'] -= 1;
            if (cnt[s-'0'] <= 0) cows += 1;
            if (cnt[g-'0'] >= 0) cows += 1;
        }
    }
    return std::to_string(bulls) + "A" + std::to_string(cows) + "B";
}
