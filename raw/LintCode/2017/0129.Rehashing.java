/*
 *  http://www.lintcode.com/en/problem/rehashing/#
 *
 *  The size of the hash table is not determinate at the very beginning.
 *  If the total size of keys is too large (e.g. size >= capacity / 10),
 *  we should double the size of the hash table and rehash every keys.
 *  Say you have a hash table looks like below:
 *      size=3, capacity=4
 *      [null, 21, 14, null]
 *             ↓    ↓
 *             9   null
 *             ↓
 *            null
 *  The hash function is:
 *      int hashcode(int key, int capacity) {
 *          return key % capacity;
 *      }
 *  here we have three numbers, 9, 14 and 21,
 *  where 21 and 9 share the same position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1).
 *  We store them in the hash table by linked list.
 *  rehashing this hash table, double the capacity, you will get:
 *      size=3, capacity=8
 *      index:   0    1    2    3     4    5    6   7
 *      hash : [null, 9, null, null, null, 21, 14, null]
 *  Given the original hash table, return the new hash table after rehashing .
 */

	public ListNode[] rehashing (ListNode[] hashTable) {
		int size = hashTable.length * 2;
		ListNode[] newHashTable = new ListNode[hashTable.length * 2];

		for (ListNode head : hashTable) {
			while (head != null) {
				
				int index = head.val % size;
				if (index < 0) index += size;
				
				
				ListNode x = new ListNode(head.val);

				if (newHashTable[index] != null) { // lintcode requires each list to be ordered
					ListNode curr = newHashTable[index];
					while (curr.next != null) curr = curr.next;
					curr.next = x;
				} else {
					newHashTable[index] = x;
				}
								
				head = head.next;
			}
		}
		return newHashTable;
	}

