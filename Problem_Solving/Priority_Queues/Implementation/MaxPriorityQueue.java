/**
 * A Max Priority Queue implementation using a binary heap.
 * Index 0 of the array is unused for simpler arithmetic.
 */
public class MaxPriorityQueue {
  private int[] heap;
  private int size;

  /**
   * Constructs a max priority queue with the given capacity.
   *
   * @param capacity the maximum number of elements the queue can hold
   */
  public MaxPriorityQueue(int capacity) {
    this.heap = new int[capacity + 1]; // index 0 unused
    this.size = 0;
  }

  /**
   * Checks if the priority queue is empty.
   *
   * @return true if empty, false otherwise
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Returns the number of elements in the priority queue.
   *
   * @return the size of the queue
   */
  public int size() {
    return this.size;
  }

  /**
   * Inserts an element into the priority queue.
   *
   * @param value the element to insert
   */
  public void insert(int value) {
    this.heap[++size] = value;
    swim(size);
  }

  /**
   * Removes and returns the maximum element from the queue.
   *
   * @return the maximum element
   */
  public int deleteMax() {
    int max = this.heap[1];
    exchange(1, size--);
    sink(1);
    return max;
  }

  // ---------------- Private Helper Methods ----------------

  /** Restores heap order by swimming up. */
  private void swim(int k) {
    while (k > 1 && isGreater(k, k / 2)) {
      exchange(k, k / 2);
      k = k / 2;
    }
  }

  /** Restores heap order bt sinking down. */
  private void sink(int k) {
    while (2 * k <= size) { // while 'k' has at least 1 child
      int j = 2 * k; // left child
      if (j < size && isLess(j, j + 1)) {
        j++; // if right child exists & is >, use right child
      }
      if (!isLess(k, j)) { // if parent >= larger child, heap satisfied
        break; // stop sinking
      }
      exchange(k, j); // otherwise swap
      k = j; // moce down to child and continue
    }
  }

  /** Returns true if element at i is greater than element at j. */
  private boolean isGreater(int i, int j) {
    return this.heap[i] > this.heap[j];
  }

  /** Returns true if element at i is less than element at j. */
  private boolean isLess(int i, int j) {
    return this.heap[i] < this.heap[j];
  }

  /** Swaps elements at indices i and j. */
  private void exchange(int i, int j) {
    int temp = this.heap[i];
    this.heap[i] = this.heap[j];
    this.heap[j] = temp;
  }

  /**
   * Main function to demonstrate the MaxPriorityQueue.
   */
  public static void main(String[] args) {
    MaxPriorityQueue pq = new MaxPriorityQueue(10);

    pq.insert(50);
    pq.insert(30);
    pq.insert(20);
    pq.insert(15);
    pq.insert(60);
    pq.insert(10);

    assert pq.size() == 6 : "Size test failed";
    assert pq.deleteMax() == 60 : "deleteMax test1 failed";
    assert pq.deleteMax() == 50 : "deleteMax test2 failed";
    assert pq.size() == 4 : "Size test after deletions failed";
    System.out.println("✅ All tests passed!");
  }
}
