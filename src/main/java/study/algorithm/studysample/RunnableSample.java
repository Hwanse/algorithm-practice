package study.algorithm.studysample;

public class RunnableSample implements Runnable {

  @Override
  public void run() {
    System.out.println("RunnableSample : " + Thread.currentThread().getName());
  }

}

