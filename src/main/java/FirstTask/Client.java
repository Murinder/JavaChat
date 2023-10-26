package FirstTask;

import java.util.Random;

public class Client extends Thread {
    private Window[] windows;
    private int category;

    public Client(Window[] windows, int category) {
        this.windows = windows;
        this.category = category;
    }

    @Override
    public void run() {
        boolean served = false;

        for (int i = 0; i < 3; i++) {
            if (i == 0 || i == category) {
                if (windows[i].service()) {
                    served = true;
                    break;
                }
            }
        }

        if (!served) {
            MFC.LeftClients[category]++;
        }

        MFC.EachClients[category]++;
    }
}
