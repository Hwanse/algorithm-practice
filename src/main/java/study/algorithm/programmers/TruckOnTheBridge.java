package study.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnTheBridge {

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Bridge bridge = new Bridge(bridge_length, weight);
    Queue<Truck> queue = new LinkedList<>();

    for(int data : truck_weights) {
      queue.add(new Truck(data, 0));
    }

    int second = 0;

    while(!queue.isEmpty() || !bridge.trucks.isEmpty()) {
      second++;

      if (!bridge.trucks.isEmpty()) {
        bridge.findPassedTruck();
      }

      if (!queue.isEmpty() && bridge.isWithinWeightLimit(queue.peek())) {
        Truck truck = queue.poll();
        bridge.enterBridge(truck);
      }

      for (Truck truck : bridge.trucks) {
        truck.moveTruck();
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

class Bridge {
  Queue<Truck> trucks;
  final int bridgeLength;
  int weightLimit;
  int currentWeight;

  public Bridge (int bridgeLength, int weightLimit) {
    this.trucks = new LinkedList<>();
    this.bridgeLength = bridgeLength;
    this.weightLimit = weightLimit;
    this.currentWeight = 0;
  }

  void enterBridge(Truck truck) {
    trucks.add(truck);
    currentWeight += truck.weight;
  }

  void findPassedTruck() {
    if (trucks.peek().distance == bridgeLength) {
      currentWeight -= trucks.poll().weight;
    }
  }

  boolean isWithinWeightLimit(Truck truck) {
    return currentWeight + truck.weight <= weightLimit;
  }
}