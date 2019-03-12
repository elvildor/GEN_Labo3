

public class RunnableTest implements Runnable {
  private String name;

  public static void main(String[] args) {
    RunnableTest t1 = new RunnableTest("Thread-0");
    RunnableTest t2 = new RunnableTest("Thread-1");
    new Thread(t1).start();
    new Thread(t2).start();
  }

  public RunnableTest(String name) {this.name = name;}

  public void run() {
    for (int i = 1; i <= 10; i++) {
        try {
    		Thread.sleep(1);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
      System.out.println(i + " " + name);
    }
  }
}
