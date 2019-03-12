

public class ThreadTest extends Thread {
  public static void main(String[] args) {
    ThreadTest t1 = new ThreadTest();
    ThreadTest t2 = new ThreadTest();
    t1.start();
    t2.start();
  }

  public void run() {
    for (int i = 1; i <= 10; i++) {
      try {
		Thread.sleep(1);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
      System.out.println(i + " " + getName());
    }
  }
}
