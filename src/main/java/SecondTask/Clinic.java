package SecondTask;

import java.util.concurrent.Semaphore;

public class Clinic {
    private static final int queueSize = 10;
    private static final int therapistPatient = 1;
    private static final int mriPatient = 1;

    public static void main(String[] args) {
        Semaphore therapistSemaphore = new Semaphore(therapistPatient);
        Semaphore mriSemaphore = new Semaphore(mriPatient);

        Thread[] patientThreads = new Thread[queueSize];

        for (int i = 0; i < queueSize; i++) {
            patientThreads[i] = new Thread(new Patient("Пациент " + (i+1), therapistSemaphore, mriSemaphore));
            patientThreads[i].start();
        }

        try {
            for (int i = 0; i < queueSize; i++) {
                patientThreads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Максимальная длина очереди: " + (queueSize - therapistSemaphore.availablePermits()));
    }
}