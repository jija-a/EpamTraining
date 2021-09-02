package by.alex.threads.ex04management;

class YieldThread extends Thread {

    public YieldThread(String name) {
        super(name);
    }

    public void run() {
        String name = getName();
        System.out.println("Thread '" + name + "' start");
        if ("First Yield".equals(name)) {
            Thread.yield();
        }
        System.out.println("Thread '" + name + "' end ");
    }

}
