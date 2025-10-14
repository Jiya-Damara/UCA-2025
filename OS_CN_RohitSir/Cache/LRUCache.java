import java.util.Map;
import java.util.HashMap;

class LRUCache {
  static class Node {
    int key;
    int val;
    Node prev, next;

    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  int capacity;
  Node head, tail;
  Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();

    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    Node valueNode = map.get(key);
    deleteNode(valueNode);
    insertAfterHead(valueNode);

    return valueNode.val;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node valueNode = map.get(key);
      valueNode.val = value;
      deleteNode(valueNode);
      insertAfterHead(valueNode);
      return;
    }

    if (map.size() == capacity) {
      Node prevTail = tail.prev;
      deleteNode(prevTail);
      map.remove(prevTail.key);
    }

    Node newNode = new Node(key, value);
    insertAfterHead(newNode);
    map.put(key, newNode);
  }

  private void deleteNode(Node node) {
    Node nextNode = node.next;
    Node prevNode = node.prev;

    prevNode.next = nextNode;
    nextNode.prev = prevNode;
  }

  private void insertAfterHead(Node node) {
    Node headNext = head.next;

    node.prev = head;
    head.next = node;
    node.next = headNext;
    headNext.prev = node;
  }

  public static void main(String[] args) {
    // Test Case 1 (Matches LeetCode Example)
    LRUCache cache = new LRUCache(2);

    cache.put(1, 1); // {1=1}
    cache.put(2, 2); // {1=1, 2=2}
    assert cache.get(1) == 1 : "Test 1 failed"; // returns 1
    System.out.println("✅ Test 1 passed: get(1) == 1");

    cache.put(3, 3); // evicts key 2 → {1=1, 3=3}
    assert cache.get(2) == -1 : "Test 2 failed"; // -1 (not found)
    System.out.println("✅ Test 2 passed: get(2) == -1");

    cache.put(4, 4); // evicts key 1 → {4=4, 3=3}
    assert cache.get(1) == -1 : "Test 3 failed"; // -1 (not found)
    System.out.println("✅ Test 3 passed: get(1) == -1");

    assert cache.get(3) == 3 : "Test 4 failed"; // returns 3
    System.out.println("✅ Test 4 passed: get(3) == 3");

    assert cache.get(4) == 4 : "Test 5 failed"; // returns 4
    System.out.println("✅ Test 5 passed: get(4) == 4");

    // Test Case 2 (update existing key)
    LRUCache cache2 = new LRUCache(2);
    cache2.put(2, 1);
    cache2.put(2, 2);
    assert cache2.get(2) == 2 : "Test 6 failed"; // updated value
    System.out.println("✅ Test 6 passed: update existing key");

    // Test Case 3 (check order after access)
    LRUCache cache3 = new LRUCache(2);
    cache3.put(1, 1);
    cache3.put(2, 2);
    cache3.get(1);       // access 1 → makes 1 MRU
    cache3.put(3, 3);    // should evict 2 (LRU)
    assert cache3.get(2) == -1 : "Test 7 failed"; // evicted
    assert cache3.get(1) == 1 : "Test 8 failed";  // still exists
    assert cache3.get(3) == 3 : "Test 9 failed";  // new one exists
    System.out.println("✅ Test 7, 8, 9 passed: correct reordering after access");

    System.out.println("\n🎉 All LRU Cache tests passed successfully!");
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
