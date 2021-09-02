package by.alex.threads.ex01helloworld;

public class HelloWorldThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello World");
    }

}
