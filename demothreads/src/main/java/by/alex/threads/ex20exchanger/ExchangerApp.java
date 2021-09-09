package by.alex.threads.ex20exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerApp {

    public static void main(String[] args) {

        Exchanger<String> ex = new Exchanger();

        int n = 5;
        for (int i = 1; i <= n; i++) {

            Thread t1 = new Thread(new PutThread(ex));
            Thread t2 = new Thread(new GetThread(ex));

            t1.setName("Поток Put " + i);
            t2.setName("Поток Get " + i);

            t1.start();
            t2.start();

        }
    }

}

