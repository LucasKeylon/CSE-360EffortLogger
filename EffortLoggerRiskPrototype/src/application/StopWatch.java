package application;

public class StopWatch {
    private boolean running; //whether stopwatch is running
    private long start; //start time in microseconds
    private long end; //end time
    
    public StopWatch() { //default constructor
        this.start = 0;
        this.end = 0;
    }
    
    public boolean isRunning() { //determines if stopwatch is running
        return running;
    }

    public void start() { //starts stopwatch
        start = System.nanoTime();
        running = true;
    }

    public long stop() { //stops stopwatch and returns elapsed time
        if (!isRunning()) {
            return -1;
        } else {
            end = System.nanoTime();
            running = false;
            return end - start;
        }
    }

    public long elapsed() { //returns total elapsed time
        if (isRunning()) {
            return (System.nanoTime() - start);
        } else
            return (end - start);
    }

    public String toString() { //returns number of seconds stopwatch has elapsed
        long enlapsed = elapsed();
        return ((double) enlapsed / 1000000000.0) + " Seconds";
    }
}