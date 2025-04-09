
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

ListNode * read_head;

int length(ListNode * head) {
    int len = 0;
    while (head) {
        len += 1;
        head = head->next;
    }
    return len;
}

TreeNode * build(int len) {
    if (len == 0) return nullptr;

    TreeNode * root = new TreeNode();
    root->left = build(len / 2);
    root->val = read_head->val;
    read_head = read_head->next;
    root->right = build(len - len / 2 - 1);
    return root;
}

TreeNode* sortedListToBST(ListNode* head) {
    int len = length(head);
    read_head = head;
    return build(len);
}
