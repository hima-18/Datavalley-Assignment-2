class Counter {
  private int count = 0;

  // Synchronized method for thread-safe increment
  public synchronized void increment() {
    count++;
  }
}

public class SynchronizationDemo implements Runnable {
  private Counter counter;

  public SynchronizationDemo(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      counter.increment();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Counter counter = new Counter();
    SynchronizationDemo thread1 = new SynchronizationDemo(counter);
    SynchronizationDemo thread2 = new SynchronizationDemo(counter);

    Thread t1 = new Thread(thread1);
    Thread t2 = new Thread(thread2);

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println("Final count: " + counter.count);
  }
}