
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


class List {
private:
    ListNode dummy;
    ListNode * tail;
public:
    List() : dummy(0), tail(&dummy) {}
    void append(ListNode * x) {
        while (x) {
            tail->next = x;
            tail = x;
            x = x->next;
        }
    }
    ListNode * get_raw() {
        return dummy.next;
    }
};


ListNode* partition(ListNode* head, int x) {

    List less;
    List eq_or_more;

    while (head) {
        ListNode * next = head->next;
        head->next = nullptr;
        if (head->val < x) { less.append(head); }
        else { eq_or_more.append(head); }
        head = next;
    }

    less.append(eq_or_more.get_raw());
    return less.get_raw();
}