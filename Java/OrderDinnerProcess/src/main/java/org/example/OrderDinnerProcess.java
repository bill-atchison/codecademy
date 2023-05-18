package org.example;

import java.lang.Thread;

public class OrderDinnerProcess {
    private boolean foodArrived = false;

    private void printTask(String task) {
        System.out.println(Thread.currentThread().getName() + " - " + task);
    }

    public void eatFood() {
        printTask("Wow, I am starving!");
        try {
            synchronized (this) {
                while (!this.foodArrived) {
                    printTask("Waiting for the food to arrive...");
                    wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        printTask("Finally! Yum yum yum!!!");
    }

    public void deliverFood() {
        printTask("Driving food over...");
        try {
            Thread.sleep(5000);
            synchronized (this) {
                this.foodArrived = true;
                printTask("Arrived!");
                notifyAll();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        OrderDinnerProcess p = new OrderDinnerProcess();
        try {
            for (int i = 0; i < 5; i++) {
                Thread eatFood = new Thread(() -> p.eatFood());
                eatFood.start();
            }
            Thread.sleep(1000);
            Thread delivery = new Thread(() -> p.deliverFood());
            delivery.start();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}