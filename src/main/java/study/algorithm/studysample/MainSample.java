package study.algorithm.studysample;


public class MainSample {

  public static void main(String[] args) {
    ThreadExample a = new ThreadExample("A");
    ThreadExample b = new ThreadExample("B");
    ThreadExample c = new ThreadExample("C");
    a.start();
    b.start();
    c.start();

    try {
      Thread.sleep(2000);
      a.suspend();
      Thread.sleep(2000);
      b.suspend();
      Thread.sleep(3000);
      a.resume();
      Thread.sleep(3000);
      a.stop();
      b.stop();
      Thread.sleep(2000);
      c.stop();
    } catch (InterruptedException e) {
    }
  }
}

class ThreadExample implements Runnable {

  boolean suspended = false;
  boolean stopped = false;

  Thread th;

  ThreadExample(String name) {
    th = new Thread(this, name);
  }

  public void run() {
    String name = th.getName();

    while (!stopped) {
      if(!suspended) {
        System.out.println(name);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println(name + " - interrupted");
        }
      } else {
        Thread.yield();
      }
    }
    System.out.println(name + " - stopped");
  }

  // 일시 정지 상태로 만든다.
  public void suspend() {
    suspended = true;
    // 쓸모없이 반복되는
    th.interrupt();
    System.out.println(th.getName() + " - interrupt() by suspend()");
  }

  public void stop() {
    stopped = true;
    th.interrupt();
    System.out.println(th.getName() + " - interrupt() by stop()");
  }

  public void resume() {
    suspended = false;
  }

  public void start() {
    th.start();
  }

}
