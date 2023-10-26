package FirstTask;


import java.util.Random;



public class MFC {
    public static int[] LeftClients;
    public static int[] EachClients;


    public static void main(String[] args) {
        int totalClients = 100; // Общее количество клиентов
        int numCategory = 3;
        LeftClients = new int[numCategory];
        EachClients = new int[numCategory];

        Window window1 = new Window(); // Первое окно
        Window window2 = new Window(); // Второе окно
        Window window3 = new Window(); // Третье окно
        Window[] windows = new Window[numCategory];
        windows[0] = window1;
        windows[1] = window2;
        windows[2] = window3;

        for (int i = 0; i < totalClients; i++) {
            int category = new Random().nextInt(numCategory);
            Client client = new Client(windows,category);
            client.start();
        }

        double youngClientsLeftPercentage = (double) LeftClients[0] / EachClients[0] * 100;
        double elderlyClientsLeftPercentage = (double) LeftClients[1] / EachClients[1] * 100;
        double businessmanClientsLeftPercentage = (double) LeftClients[2] / EachClients[2] * 100;

        System.out.println("Процент ушедших молодых клиентов: " + youngClientsLeftPercentage + "%" + " " + EachClients[0]);
        System.out.println("Процент ушедших пожилых клиентов: " + elderlyClientsLeftPercentage + "%" + " " + EachClients[1]);
        System.out.println("Процент ушедших бизнесменов: " + businessmanClientsLeftPercentage + "%" + " " + EachClients[2]);
    }
}




