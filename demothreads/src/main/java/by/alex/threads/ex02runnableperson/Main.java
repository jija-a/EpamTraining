package by.alex.threads.ex02runnableperson;

public class Main {

    public static void main(String[] args) {

        RunnablePerson person1 = new RunnablePerson("Alex");
        RunnablePerson person2 = new RunnablePerson("Martin");
        Thread thread1 = new Thread(person1);
        Thread thread2 = new Thread(person2);

        thread1.start();
        thread2.start();
    }

}
