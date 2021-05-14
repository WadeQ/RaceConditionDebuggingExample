public class CounterWithSynchronizedLock {

    private long count = 0 ;
    private final Object lock = new Object() ;

    public void counterThenGet() {
        synchronized (lock){
            this.count++ ;
        }

    }

    public long getCount() {
        return count;
    }
}
