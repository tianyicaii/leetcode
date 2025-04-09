
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {

    ListNode dummy;
    ListNode *prev = &dummy;
    while (list1 || list2) {
        if (list1 == nullptr) {
            prev->next = list2;
            list2 = list2->next;
        } else if (list2 == nullptr) {
            prev->next = list1;
            list1 = list1->next;
        } else if (list1->val <= list2->val) {
            prev->next = list1;
            list1 = list1->next;
        } else {
            prev->next = list2;
            list2 = list2->next;
        }
        prev = prev->next;
    }
    return dummy.next;

}
