package by.alex.threads.ex19executor_callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CalcCallable implements Callable<Number> {

    @Override
    public Number call() throws Exception {
        return new Random().nextGaussian();
    }

}
