package study.algorithm.studysample;

public class ThreadSample extends Thread {

  @Override
  public void run() {
    System.out.println("ThreadSample : " + Thread.currentThread().getName());
  }

}
