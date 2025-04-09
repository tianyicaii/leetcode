#include <numeric>
#include <vector>

int canCompleteCircuit(std::vector<int>& gas, std::vector<int>& cost) {

    int start = 0;
    int left = 0;

    int sum_gas = std::accumulate(gas.begin(), gas.end(), 0);
    int sum_cost = std::accumulate(cost.begin(), cost.end(), 0);
    if (sum_cost > sum_gas) return -1;


    for (int i = 0; i < gas.size(); ++i) {
        left += (gas[i] - cost[i]);
        if (left < 0) {
            left = 0;
            start = i + 1;
        }
    }

    return start;
}
