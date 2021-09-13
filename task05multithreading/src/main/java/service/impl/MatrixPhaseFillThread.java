package service.impl;

import domain.Matrix;

import java.util.concurrent.Phaser;

class MatrixPhaseFillThread implements  Runnable {

    Phaser phaser;
    String name;

    MatrixPhaseFillThread(Phaser p, String n) {

        this.phaser = p;
        this.name = n;
        phaser.register();
    }

    @Override
    public void run() {
        //todo
        /*System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута

        try {
            Thread.sleep(200);

            System.out.println(name + " выполняет фазу " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута

            Thread.sleep(200);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты*/
    }

}
