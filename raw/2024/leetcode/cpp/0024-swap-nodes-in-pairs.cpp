
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


ListNode* swapPairs(ListNode* head) {


    ListNode dummy(0, head);
    ListNode *prev = &dummy;

    while (prev->next && prev->next->next) {
        ListNode * a = prev->next;
        ListNode * b = prev->next->next;
        prev->next = b;
        a->next = b->next;
        b->next = a;
        prev = a;
    }
    return dummy.next;

}