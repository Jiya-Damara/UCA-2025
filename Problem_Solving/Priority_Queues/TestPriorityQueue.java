import java.util.PriorityQueue;
/**
 * In Java we have minPriority Queue.
 * For maxPriority Queue we just switch the signs.
*/

public class TestPriorityQueue {
  /**
   * Entry point of the program.
   *
   * @param args the command line arguments
   */

  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    pq.offer(5);
    pq.offer(6);
    pq.offer(7);
    pq.offer(-1);
    pq.offer(19);

    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.poll());
  }
}
