public class CalculateSumThread extends Thread {

  private int sumUpto;
  public CalculateSumThread(int sumUpto) {
    this.sumUpto = sumUpto;
  }

  @Override
  public void run() {
    // Sum
    // Take a rest for 5 sec
    // Print the sum with the name

    int sum = 0;
    for (int i = 0; i < sumUpto; i++) {
      sum += i;
    }

    try {
      Thread.sleep(5000);
    } catch (Exception e) {
    }

    System.out.println(Thread.currentThread().getName() + " " + sum);
  }

  public static void main(String[] args) {
    CalculateSumThread st1 = new CalculateSumThread(10);
    CalculateSumThread st2 = new CalculateSumThread(100);
    CalculateSumThread st3 = new CalculateSumThread(1000);

    // This class extends Thread class, so all methods are available
    st1.setName("Extending Thread class");
    st1.start();
    // st1.start(); -> if we start again the thread that is started, we get an IllegalThreadStateException
    st2.start();
    st3.start();
  }
}
