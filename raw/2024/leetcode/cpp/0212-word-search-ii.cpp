#include <memory>
#include <set>
#include <string>
#include <vector>


class Trie {

public:

    std::vector<std::unique_ptr<Trie>> children {26};
    bool is_word = false;

    void add(const std::string & word) {
        Trie * curr = this;
        for (char c : word) {
            int idx = c - 'a';
            if (!curr->children[idx]) curr->children[idx].reset(new Trie);
            curr = curr->children[idx].get();
        }
        curr->is_word = true;
    }
};


class Solution {

    std::set<std::string> ans;
    Trie t;
    int M = 0;
    int N = 0;

    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};

public:

    void find(std::vector<std::vector<char>> & board, std::vector<std::vector<bool>> & visited, Trie * t, std::string & path, int i, int j) {

        path.push_back(board[i][j]);
        visited[i][j] = true;

        if (t->is_word) ans.insert(path);

        for (int d = 0; d < 4; ++d) {
            int x = i + dx[d];
            int y = j + dy[d];
            if (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y] && t->children[board[x][y] - 'a']) {
                find(board, visited, t->children[board[x][y] - 'a'].get(), path, x, y);
            }
        }

        visited[i][j] = false;
        path.pop_back();
    }

    std::vector<std::string> findWords(std::vector<std::vector<char>> & board, std::vector<std::string>& words) {

        M = board.size();
        N = board[0].size();
        std::vector<std::vector<bool>> visited(M, std::vector<bool>(N));
        std::string path;
        for (const auto & w : words) {
            t.add(w);
        }
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (t.children[board[i][j] - 'a']) {
                    find(board, visited, t.children[board[i][j] - 'a'].get(), path, i, j);
                }
            }
        }
        return std::vector<std::string>(ans.begin(), ans.end());
    }

};
