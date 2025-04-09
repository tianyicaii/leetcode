#include <vector>
#include <string>


int N;
std::vector<bool> R;
std::vector<bool> C;
std::vector<bool> D;
std::vector<bool> A;


int get_R(int i, int j) {
    return i;
}
int get_C(int i, int j) {
    return j;
}
int get_D(int i, int j) {
    return N-1 + j - i;
}
int get_A(int i, int j) {
    return i + j;
}


std::vector<std::vector<std::string>> ans;


bool can_fill(int i, int j) {
    return !R[get_R(i, j)] && !C[get_C(i, j)] && !D[get_D(i, j)] && !A[get_A(i, j)];
}


void fill_cell(int i, int j, std::vector<std::string>& board) {
    R[get_R(i, j)] = C[get_C(i, j)] = D[get_D(i, j)] = A[get_A(i, j)] = true;
    board[i][j] = 'Q';
}


void clear_cell(int i, int j, std::vector<std::string>& board) {
    R[get_R(i, j)] = C[get_C(i, j)] = D[get_D(i, j)] = A[get_A(i, j)] = false;
    board[i][j] = '.';
}


void fill(int count, int p, std::vector<std::string>& board) {

    if (count == 0) {
        ans.push_back(board);
        return;
    }

    if (p == N * N) {
        return;
    }

    int i = p / N;
    int j = p % N;

    if (can_fill(i, j)) {
        fill_cell(i, j, board);
        fill(count - 1, p + 1, board);
        clear_cell(i, j, board);
    }
    fill(count, p + 1, board);
}

std::vector<std::vector<std::string>> solveNQueens(int n) {
    ans.clear();
    N = n;
    R = std::vector<bool>(N);
    C = std::vector<bool>(N);
    D = std::vector<bool>(2 * N);
    A = std::vector<bool>(2 * N);
    ans = std::vector<std::vector<std::string>>();
    std::vector<std::string> board(N, std::string(N, '.'));
    fill(N, 0, board);
    return ans;
}
