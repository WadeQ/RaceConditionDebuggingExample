package org.wadektech.example;

public class RaceConditionExample {

    private static Runnable getRunnable(Counter counter , String output) {
        return () -> {
            for (int i = 0 ; i < 1_000_000 ; i++){
               counter.counterThenGet();
            }

              System.out.println(output + counter.getCount());
        } ;

    }

    public static void main(String[] args) {
        computeCounter();
    }

    private static void computeCounter(){
        Counter counter = new Counter() ;

        Thread threadOne = new Thread(getRunnable(counter , "Thread one count is: "));
        Thread threadTwo = new Thread(getRunnable(counter , "Thread two count is: "));

        threadOne.start();
        threadTwo.start();
    }

}
