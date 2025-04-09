#include <map>
#include <string>

std::string fractionToDecimal(int numerator, int denominator) {

    if (numerator == 0) return "0";

    long D = denominator;
    long N = numerator;

    std::string ans;
    int sign = 1;
    if (N < 0) {
        sign = -sign;
        N = -N;
    }
    if (D < 0) {
        sign = -sign;
        D = -D;
    }
    if (sign == -1) {
        ans = "-";
    }

    long Q = N / D;
    long R = N % D;
    ans.append(std::to_string(Q));
    if (!R) return ans;

    ans.push_back('.');
    std::map<long, int> r_2_p;

    while (R) {
        if (r_2_p.count(R)) {
            ans.insert(r_2_p[R], "(");
            ans.push_back(')');
            return ans;
        }

        long q = 10 * R / D;
        r_2_p[R] = ans.size();
        ans.append(std::to_string(q));
        R = (10 * R) % D;
    }

    return ans;
}