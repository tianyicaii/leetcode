
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* reverseList(ListNode* head) {

    ListNode dummy;

    while (head) {
        ListNode * next = head->next;
        head->next = dummy.next;
        dummy.next = head;
        head = next;
    }

    return dummy.next;
}
