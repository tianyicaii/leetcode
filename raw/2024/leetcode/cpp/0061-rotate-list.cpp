


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


ListNode* rotateRight(ListNode* head, int k) {

    if (!head) { return nullptr; }

    ListNode dummy(0, head);
    ListNode *prev = &dummy;
    ListNode *curr = head;

    int N = 0;
    while (curr != nullptr) {
        prev = curr;
        curr = curr->next;
        N += 1;
    }

    prev->next = dummy.next;
    prev = &dummy;
    k %= N;
    for (int i = 0; i < N - k; ++i) {
        prev = prev->next;
    }
    ListNode * ans = prev->next;
    prev->next = nullptr;
    return ans;
}
