
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* reverseBetween(ListNode* head, int left, int right) {


    ListNode dummy(0, head);
    ListNode * prev = &dummy;
    ListNode * curr = head;

    int i = 1;
    while (i < left) {
        curr = curr->next;
        prev = prev->next;
        i++;
    }

    ListNode * end = curr;

    while (i <= right) {
        ListNode * next = curr->next;
        curr->next = prev->next;
        prev->next = curr;
        curr = next;
        i++;
    }

    end->next = curr;
    return dummy.next;

}
