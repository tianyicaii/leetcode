

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


ListNode* removeNthFromEnd(ListNode* head, int n) {

    ListNode dummy(0, head);
    ListNode *left = &dummy;
    ListNode *right = &dummy;

    if (head == nullptr) { return nullptr; }  // invalid list
    if (n < 1) { return nullptr; }  // invalid n

    for (int i = 0; i <= n; ++i) {
        if (right == nullptr) { return nullptr; }  // invalid n
        right = right->next;
    }

    while (right != nullptr) {
        right = right ->next;
        left = left->next;
    }

    auto to_be_removed = left->next;
    left->next = left->next->next;
    delete to_be_removed;
    return dummy.next;
}
