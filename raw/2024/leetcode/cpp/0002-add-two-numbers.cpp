// https://leetcode.com/problems/add-two-numbers/

struct ListNode {
    int val;
    ListNode * next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode * next) : val(x), next(next) {}
};

#include <memory>

ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {

    std::unique_ptr<ListNode> head(new ListNode());
    ListNode * curr = head.get();
    int carry = 0;

    while (l1 || l2 || carry != 0) {
        int x = l1 ? l1->val : 0;
        int y = l2 ? l2->val : 0;
        int sum = x + y + carry;
        carry = sum / 10;
        curr->next = new ListNode(sum % 10);

        l1 = l1 ? l1->next : nullptr;
        l2 = l2 ? l2->next : nullptr;
        curr = curr->next;
    }
    return head->next;
}
