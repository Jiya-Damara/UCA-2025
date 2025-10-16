public class CalculateSumRunnable implements Runnable {

  private int sumUpto;
  public CalculateSumRunnable(int sumUpto) {
    this.sumUpto = sumUpto;
  }

  // Force implemetation of method defined in Interface
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
    CalculateSumRunnable runnable = new CalculateSumRunnable(10);

    // Runnable doesn't belong to Thread family so we have to pass implementation to a thread
    Thread thread = new Thread(runnable);
    thread.start();

    // Method nhi honge (use case: itna access nhi dena) 
    // runnable.setName(); runnable.start(); -> cannot do so
    // thread.setName(); -> can do so
  }
}

// Runnable = a Job you give someone.
// Thread = the Worker who actually performs the job.
// You can rename the worker, decide how fast they work (priority), or make them start working — but you can’t rename the job sheet itself.