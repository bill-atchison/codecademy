package org.example;

class IntegerMapper{
    public int[] array = {1, 2, 3, 4, 5};
    public synchronized void incrementElement(int i, int j){
        array[i] += j;
    }
}
public class Main{
    public static void main(String args[]) throws InterruptedException{
        IntegerMapper iMapper = new IntegerMapper();
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                iMapper.incrementElement(2, 4);
                try{
                    Thread.sleep(10);
                }
                catch(InterruptedException exception){
                    System.out.println("Error!");
                }
            }

        });
        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                iMapper.incrementElement(2, 3);
                try{
                    Thread.sleep(10);
                }
                catch(InterruptedException exception){
                    System.out.println("Error!");
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(iMapper.array[2]);
    }
}