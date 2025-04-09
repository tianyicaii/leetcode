#include <cstdlib>
#include <vector>

class TicTacToe {


    std::vector<int> rows;
    std::vector<int> cols;
    int diagonal;
    int anti_diagonal;
    const int N;

public:
    TicTacToe(int n) : rows(n), cols(n), diagonal(0), anti_diagonal(0), N(n) {}

    int move(int row, int col, int player) {
        int incr = player == 1 ? 1 : -1;
        rows[row] += incr;
        cols[col] += incr;
        if (row == col) diagonal += incr;
        if (row == N - col - 1) anti_diagonal += incr;
        if (std::abs(rows[row]) == N ||
            std::abs(cols[col]) == N ||
            std::abs(diagonal) == N ||
            std::abs(anti_diagonal) == N) return player;
        return 0;
    }
};
