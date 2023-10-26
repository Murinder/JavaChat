package SecondTask;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Patient implements Runnable {
    private final String name;
    private final Semaphore therapistSemaphore;
    private final Semaphore mriSemaphore;

    public Patient(String name, Semaphore therapistSemaphore, Semaphore mriSemaphore) {
        this.name = name;
        this.therapistSemaphore = therapistSemaphore;
        this.mriSemaphore = mriSemaphore;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            therapistSemaphore.acquire();
            System.out.println(name + " зашел к терапевту");
            Thread.sleep(100); 
            System.out.println(name + " закончил осмотр");
            therapistSemaphore.release();

            mriSemaphore.acquire();
            System.out.println(name + " отправился на МРТ");
            Thread.sleep(200); 
            System.out.println(name + " закончил МРТ");
            mriSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
