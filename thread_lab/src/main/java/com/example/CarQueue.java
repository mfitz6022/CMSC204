package com.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {

  Queue<Integer> directionQueue;
  Random random;

  public CarQueue() {
    directionQueue = new LinkedList<>();
    random = new Random();
    directionQueue.add(0);
    directionQueue.add(1);
    directionQueue.add(2);
    directionQueue.add(3);
    directionQueue.add(0);
  }

  public void addToQueue() {

    class RandomDirection implements Runnable {
        public void run() {
            try {
                for (int i = 0; i < 1000; i++) {
                    int rand = random.nextInt(4);
                    directionQueue.add(rand);
                    Thread.sleep(50);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
      }
    }

    Runnable r = new RandomDirection();
    Thread t = new Thread(r);
    t.start();
  }

  public int deleteQueue() {
    return directionQueue.remove();
  }

}
