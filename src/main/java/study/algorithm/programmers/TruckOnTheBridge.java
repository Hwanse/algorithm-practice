package study.algorithm.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TruckOnTheBridge {

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    List<Truck> bridge = new ArrayList<>();
    Queue<Truck> queue = new LinkedList<>();
    for(int data : truck_weights) {
      queue.add(new Truck(data, 0));
    }

    int second = 0;
    int currentWeight = 0;

    while(!queue.isEmpty() || !bridge.isEmpty()) {

      second++;
      bridge.removeIf(truck -> truck.distance >= bridge_length);

      if (!queue.isEmpty() && currentWeight + queue.peek().weight <= weight) {
        Truck truck = queue.poll();
        currentWeight += truck.weight;
        bridge.add(truck);
      }

      for (Truck truck : bridge) {
        if (truck.distance + 1 == bridge_length) {
          currentWeight -= truck.weight;
          truck.moveTruck();
        } else {
          truck.moveTruck();
        }
      }

    }

    return second;
  }

}

class Truck {
  int weight;
  int distance;

  public Truck(int weight, int distance) {
    this.weight = weight;
    this.distance = distance;
  }

  public void moveTruck() {
    this.distance += 1;
  }
}