package study.algorithm.studysample;

public class ThreadPractice {

  public static String r1 = "자원1";
  public static String r2 = "자원2";

  public static void main(String[] args) {
    Runnable r1 = new Sample();
    Runnable r2 = new Sample2();

    new Thread(r1).start();
    new Thread(r2).start();
  }
}

class Sample implements Runnable {

  @Override
  public void run() {

    synchronized (ThreadPractice.r1) {
      System.out.println(Thread.currentThread().getName() + " r1 점유중..");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      System.out.println(Thread.currentThread().getName() + " r2 대기중..");
      synchronized (ThreadPractice.r2) {
        System.out.println(Thread.currentThread().getName() + " r2 점유중..");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
      }
    }

  }

}

class Sample2 implements Runnable {

  @Override
  public void run() {

    synchronized (ThreadPractice.r2) {
      System.out.println(Thread.currentThread().getName() + " r2 점유중..");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      System.out.println(Thread.currentThread().getName() + " r1 대기중..");
      synchronized (ThreadPractice.r1) {
        System.out.println(Thread.currentThread().getName() + " r1 점유중..");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
      }
    }

  }

}