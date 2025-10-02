import java.util.*;

class MyStack {
  private Queue<Integer> q;

  public MyStack() {
    q = new LinkedList<>();
  }

  public void push(int item) {
    q.offer(item);
    int size = q.size();
    for(int i = 1; i < size; i++) {
      q.offer(q.poll());
    }
  }

  public int pop() {
    if(q.isEmpty()) {
      throw new NoSuchElementException("Stack is Empty.");
    }
    return q.poll();
  }

  public int peek() {
    if(q.isEmpty()) {
      throw new NoSuchElementException("Stack is Empty.");
    }
    return q.peek();
  }

  public boolean isEmpty() {
    return q.isEmpty();
  }

  public int size() {
    return q.size();
  }
}

public class Stack_Using_Queue {
  public static void main(String[] args) {
    MyStack stack = new MyStack();

    stack.push(10);
    stack.push(20);
    stack.push(30);
    assert stack.size() == 3 : "Size should be 3";
    assert stack.peek() == 30 : "Peek should be 30";

    assert stack.pop() == 30 : "Pop should be 30";
    assert stack.pop() == 20 : "Pop should be 20";
    assert stack.pop() == 10 : "Pop should be 10";
    assert stack.isEmpty() : "Stack should be empty";

    boolean exceptionThrown = false;
    try {
      stack.pop();
    }
    catch(NoSuchElementException e) {
      exceptionThrown = true;
    }
    assert exceptionThrown: "Pop on empty stack should throw exception";
    System.out.println("ALL TESTS PASSED!!");
  }
}
