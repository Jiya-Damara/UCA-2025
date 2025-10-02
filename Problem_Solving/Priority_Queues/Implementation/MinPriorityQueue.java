/**
 * A Min Priority Queue implementation using a binary heap.
 * Index 0 of the array is unused for simpler arithmetic.
 */
public class MinPriorityQueue {
  private int[] heap;
  private int size;

  /**
   * Constructs a min priority queue with the given capacity.
   *
   * @param capacity the maximum number of elements the queue can hold
   */
  public MinPriorityQueue(int capacity) {
    this.heap = new int[capacity + 1];
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
   * Removes and returns the minimum element from the queue.
   *
   * @return the minimum element
   */
  public int deleteMin() {
    int min = heap[1];
    exchange(1, size--);
    sink(1);
    return min;
  }

  // ---------------- Private Helper Methods ----------------

  /** Restores heap order by swimming up. */
  private void swim(int k) {
    while (k > 1 && isLess(k, k / 2)) {
      exchange(k, k / 2);
      k = k / 2;
    }
  }

  /** Restores heap order by sinking down. */
  private void sink(int k) {
    while (2 * k <= size) {
      int j = 2 * k;
      if (j < size && isGreater(j, j + 1)) {
        j++;
      }
      if (!isGreater(k, j)) {
        break;
      }
      exchange(k, j);
      k = j;
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
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  /**
   * Main function to demonstrate the MaxPriorityQueue.
   */
  public static void main(String[] args) {
    MinPriorityQueue pq = new MinPriorityQueue(10);

    pq.insert(50);
    pq.insert(30);
    pq.insert(20);
    pq.insert(15);
    pq.insert(60);
    pq.insert(10);

    assert pq.size() == 6 : "Size test failed";
    assert pq.deleteMin() == 10 : "deleteMin test1 failed";
    assert pq.deleteMin() == 15 : "deleteMin test2 failed";
    assert pq.size() == 4 : "Size test after deletions failed";
    System.out.println("✅ All tests passed!");
  }
}
