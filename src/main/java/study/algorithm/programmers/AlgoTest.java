package study.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class AlgoTest {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck2> trucks = setup(truck_weights);
        Bridge2 bridge = new Bridge2(weight, bridge_length);

        while (!trucks.isEmpty() || !bridge.isEmpty()) {
            answer++;

            if (!bridge.isEmpty()) {
                bridge.passTruck();
            }

            if(!trucks.isEmpty() && !bridge.isOverflow(trucks.peek())) {
                bridge.enterBridge(trucks.poll());
            }

            bridge.moveTrucks();
        }

        return answer;
    }

    private Queue<Truck2> setup(int[] truck_weights) {
        Queue<Truck2> trucks = new LinkedList<>();
        for (int w : truck_weights) {
            trucks.add(new Truck2(w, 0));
        }
        return trucks;
    }

}

class Truck2 {
    private int weight;
    private int distance;

    public Truck2 (int weight, int distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public void move() {
        distance++;
    }

    public int getWeight() {
        return weight;
    }

    public int getDistance() {
        return distance;
    }
}

class Bridge2 {
    private Queue<Truck2> currentTrucks = new LinkedList<>();

    private int currentWeight;
    private int limitWeight;
    private int length;

    public Bridge2 (int limitWeight, int length) {
        this.limitWeight = limitWeight;
        this.length = length;
        currentWeight = 0;
    }

    public void enterBridge(Truck2 truck) {
        currentTrucks.offer(truck);
        currentWeight += truck.getWeight();
    }

    public void moveTrucks() {
        currentTrucks.forEach(Truck2::move);
    }

    public void passTruck() {
        if (currentTrucks.peek().getDistance() >= length) {
            Truck2 finishedTruck = currentTrucks.poll();
            currentWeight -= finishedTruck.getWeight();
        }
    }

    public boolean isOverflow(Truck2 truck) {
        return currentWeight + truck.getWeight() > limitWeight;
    }

    public boolean isEmpty() {
        return currentTrucks.isEmpty();
    }

    public int getLength() {
        return length;
    }
}