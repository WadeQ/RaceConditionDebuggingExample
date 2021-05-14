package org.wadektech.example;

public class RaceConditionExampleSolution {

    private static Runnable getRunnable(CounterWithSynchronizedLock counter , String output) {
        return () -> {
            for (int i = 0 ; i < 1_000_000 ; i++){
                counter.counterThenGet();
            }

            System.out.println(output + counter.getCount());
        } ;

    }

    public static void main(String[] args) {
        executeCounter();
    }

    private static void executeCounter(){
        CounterWithSynchronizedLock counter = new CounterWithSynchronizedLock() ;

        Thread threadOne = new Thread(getRunnable(counter , "Thread one count is: "));
        Thread threadTwo = new Thread(getRunnable(counter , "Thread two count is: "));

        threadOne.start();
        threadTwo.start();
    }

}
