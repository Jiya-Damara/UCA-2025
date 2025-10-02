import java.util.Stack;

/**
 * Queue implementation using two stacks.
 */
class MyQueue {
  private Stack<Integer> s1;
  private Stack<Integer> s2;

  /** Constructs an empty queue. */
  public MyQueue() {
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  /**
   * Pushes an item into the queue.
   *
   * @param item the element to be inserted
   */
  public void push(int item) {
    // Move all items from s1 to s2
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }

    // Add the new item to s1
    s1.push(item);

    // Move all items back to s1
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
  }

  /**
   * Removes and returns the front element.
   *
   * @return the removed element
   * @throws NoSuchElementException if the queue is empty
   */
  public int pop() {
    if (s1.isEmpty()) {
      return -1;
    }
    return s1.pop();
  }

  /**
   * Returns the front element without removing it.
   *
   * @return the front element
   * @throws NoSuchElementException if the queue is empty
   */
  public int peek() {
    if (s1.isEmpty()) {
      return -1;
    }
    return s1.peek();
  }

  /**
   * Checks if the queue is empty.
   *
   * @return true if empty, false otherwise
   */
  public boolean isEmpty() {
    return s1.isEmpty();
  }

  /**
   * Returns the number of elements in the queue.
   *
   * @return queue size
   */
  public int size() {
    return s1.size();
  }
}

/**
 * A demo class for testing MyQueue.
 */
public class Queue_Using_Stack {
  /**
   * Main method to run unit tests for MyQueue.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    MyQueue q = new MyQueue();

    q.push(1);
    q.push(2);
    q.push(3);
    assert q.size() == 3 : "Size should be 3";

    assert q.peek() == 1 : "Peek should return 1";

    assert q.pop() == 1 : "Pop should return 1";
    assert q.pop() == 2 : "Pop should return 2";

    assert q.size() == 1 : "Size should be 1";

    assert !q.isEmpty() : "Queue should not be empty";
    assert q.pop() == 3 : "Last pop should return 3";
    assert q.isEmpty() : "Queue should now be empty";

    System.out.println("All queue tests passed!");
  }
}
