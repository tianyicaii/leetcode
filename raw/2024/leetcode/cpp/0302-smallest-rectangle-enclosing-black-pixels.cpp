#include <vector>


bool has_dot_on_col(std::vector<std::vector<char>>& image, int c) {
    for (int i = 0; i < image.size(); ++i) {
        if (image[i][c] == '1') return true;
    }
    return false;
}


bool has_dot_on_row(std::vector<std::vector<char>>& image, int r) {
    for (int i = 0; i < image[0].size(); ++i) {
        if (image[r][i] == '1') return true;
    }
    return false;
}


int minArea(std::vector<std::vector<char>>& image, int x, int y) {

    int l = 0;
    int r = 0;
    int t = 0;
    int b = 0;
    int M = image.size();
    int N = image[0].size();

    // left
    {
        int i = 0;
        int j = y;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (has_dot_on_col(image, m)) j = m;
            else i = m + 1;
        }
        l = j;
    }
    // right
    {
        int i = y + 1;
        int j = N;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (has_dot_on_col(image, m)) i = m + 1;
            else j = m;
        }
        r = i - 1;
    }
    // top
    {
        int i = 0;
        int j = x;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (has_dot_on_row(image, m)) j = m;
            else i = m + 1;
        }
        t = j;
    }
    // bottom
    {
        int i = x + 1;
        int j = M;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (has_dot_on_row(image, m)) i = m + 1;
            else j = m;
        }
        b = i - 1;
    }
    return (b - t + 1) * (r - l + 1);
}
