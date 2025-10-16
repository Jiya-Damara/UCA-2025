import java.util.*;

public class ThreadInfo {
  static int a = 10;

  public static void main(String[] args) {

    // Thread lifecycle - New -> Running -> Blocked -> Terminate
    Thread t1 = new Thread();
    int sum1 = 0;
    for (int i = 0; i <= 1000; i++) {
      sum1 += i;
    }
    System.out.println(Thread.currentThread().getName() + " " + sum1);

    Thread t2 = new Thread();
    int sum2 = 0;
    for (int i = 0; i <= 1000; i++) {
      sum2 += i;
    }
    System.out.println(Thread.currentThread().getName() + " " + sum2);
  
    // min priority is 1, max is 10. default is of main(parent fnc). Incase of main 5.
    t2.setPriority(10);
    t1.setName("Jiya");

    t1.start(); // forks the thread internally, it calls run() method first
    t2.start();
    t1.run(); // it only implements the thread, not envoking it

    long product = 1;
    for (int i = 1; i < 1000; i++) {
      product *= i;
    } 
    a += 5;
    System.out.println(Thread.currentThread().getName() + " " + product + " " + a);

    Thread[] t = new Thread[1000];
    t[0] = new Thread();
    t[0].setPriority(1);

    int s = 0;
    for (int i = 0; i <= 1000; i++) {
      s += i;
    }
    System.out.println(Thread.currentThread().getName() + " " + s);

    // 3 ways to implement methods in a particular thread
    // Way 1 - Lambda Function
    Thread th1 = new Thread(() -> {
      // Implement here
      System.out.println(Thread.currentThread().getName());
    });

    th1.setName("Jiya");
    th1.setPriority(10);
    th1.start();
    th1.run();
    System.out.println(Thread.currentThread().getName());

    // Way 2 -> Through creating a class of our own & extending Thread class - Done in CalculateSumThread.jva
    // Way 3 -> Through Runnable interface - Done in CalculateSumRunnable.java
  }
}
