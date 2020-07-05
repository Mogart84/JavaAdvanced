package lesson5prof;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static int finishCount = 0; // Флаг кол-ва дошедших до финиша (по сути 0 или не-0)
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch cdl;
    private Semaphore smp;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch cdl, Semaphore smp) {
        this.race = race;
        this.speed = speed;
        this.cdl = cdl;
        this.smp = smp;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            cdl.await();
            Thread.sleep(100); //Сделано, чтобы вызов успел вернуться в главный поток - иначе сразу после
                                        // обнуления cdl запускается гонка, main не успевает вывести сообщение
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this,smp);
        }

        //Если еще никто не финишировал, данный объект Car объявляется победителем
        if (finishCount == 0) {
            System.out.println(this.getName() + " - WIN!");
            finishCount += 1;
        }

    }
}