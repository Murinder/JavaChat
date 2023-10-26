package FirstTask;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Window extends Thread{
    //Semaphore semaphore = new Semaphore(1);
    private boolean busy = false;

    public synchronized boolean service(){
        if (!busy) {
            this.busy = true;
            return busy;
        }
        this.busy = false;
        return busy;
    }

}