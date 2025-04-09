
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* deleteDuplicates(ListNode* head) {

    ListNode dummy(0, nullptr);
    ListNode * prev = & dummy;
    ListNode * curr = head;

    while (curr) {
        ListNode * prob = curr->next;
        while (prob && prob->val == curr->val) prob = prob->next;
        if (prob == curr->next) {
            prev->next = curr;
            prev = curr;
            curr = curr->next;
        } else {
            curr = prob;
        }
    }
    prev->next = nullptr;
    return dummy.next;
}
