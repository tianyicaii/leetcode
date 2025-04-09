

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* removeElements(ListNode* head, int val) {
    ListNode dummy;
    ListNode * prev = & dummy;
    while (head) {

        ListNode * curr = head;
        head = head->next;
        curr->next = nullptr;

        if (curr->val == val) {
            delete curr;
        } else {
            prev->next = curr;
            prev = curr;
        }
    }

    return dummy.next;
}
