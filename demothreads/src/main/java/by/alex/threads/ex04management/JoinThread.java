package by.alex.threads.ex04management;

class JoinThread extends Thread {

    public JoinThread(String name) {
        super(name);
    }

    public void run() {
        String name = getName();
        long timeout = 0;
        System.out.println("Thread '" + name + "' start");
        try {
            switch (name) {
                case "First":
                    timeout = 5_000;
                    break;
                case "Second":
                    timeout = 1_000;
            }
            Thread.sleep(timeout);
            System.out.println("Thread '" + name + "' end ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
