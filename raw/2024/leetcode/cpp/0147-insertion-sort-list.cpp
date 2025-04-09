

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


ListNode* insertionSortList(ListNode* head) {

    ListNode dummy;
    ListNode * curr = head;

    while (curr) {
        ListNode * i = &dummy;
        while (i->next && i->next->val <= curr->val) {
            i = i->next;
        }

        ListNode * next = curr->next;
        curr->next = i->next;
        i->next = curr;
        curr = next;
    }
    return dummy.next;
}
