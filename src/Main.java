import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

//Maximum threads allowed to run simultaneously



    public static void main(String[] args)
    {
        ThreadHandler threadH = new ThreadHandler();
       threadH.Threads();
    }



}
