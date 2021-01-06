

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    CyclicBarrier cb = new CyclicBarrier(MainClass.CARS_COUNT);
    private Race race;
    private int speed;
    private String name;
    Lock lock = new ReentrantLock();

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
        }
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println(this.name + " WIN");
        } finally {
            lock.unlock();
        }
    }
}