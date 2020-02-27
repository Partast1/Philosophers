import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
//Maximum threads allowed to run simultaneously
    static final int MAX_T = 3;

//    Philosopher p1 = new Philosopher();
//    Philosopher p2 = new Philosopher();
//    Philosopher p3 = new Philosopher();
//    Philosopher p4 = new Philosopher();
//    Philosopher p5 = new Philosopher();

//    static Fork f1 = new Fork();
//    static Fork f2 = new Fork();
//    static Fork f3 = new Fork();
//    static Fork f4 = new Fork();
//    static Fork f5 = new Fork();

    static ReentrantLock fork1 = new ReentrantLock();
    static ReentrantLock fork2 = new ReentrantLock();
    static ReentrantLock fork3 = new ReentrantLock();
    static ReentrantLock fork4 = new ReentrantLock();
    static ReentrantLock fork5 = new ReentrantLock();

    static Runnable p1 = new Philosopher();
    static Runnable p2 = new Philosopher();
    static Runnable p3 = new Philosopher();
    static Runnable p4 = new Philosopher();
    static Runnable p5 = new Philosopher();

    public static void main(String[] args)
    {
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        while (true) {
        pool.execute(p1);
        pool.execute(p2);
        pool.execute(p3);
        pool.execute(p4);
        pool.execute(p5);


//region Philosopher 1 is trying to eat
            if(!fork1.isLocked())
            {
                fork1.lock();
                    if(!fork5.isLocked())
                    {
                        fork5.lock();
                    p1.run();
                    }
                    else
                        {
                            try
                            {
                                Thread.sleep(500);
                            }
                            catch (Exception e)
                            {

                            }
                        }
            }
            else
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {

                }
            }
//endregion
//region Philosopher 2 is trying to eat
            if(!fork2.isLocked())
            {
                fork2.lock();
                if(!fork1.isLocked())
                {
                    fork1.lock();
                    p2.run();
                }
                else
                {
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
            else
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {

                }
            }
            //endregion
// region Philosopher 3 is trying to eat
            if(!fork3.isLocked())
            {
                fork3.lock();
                if(!fork2.isLocked())
                {
                    fork2.lock();
                    p3.run();
                }
                else
                {
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
            else
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {

                }
            }
            //endregion
//region Philosopher 4 is trying to eat
            if(!fork4.isLocked())
            {
                fork4.lock();
                if(!fork3.isLocked())
                {
                    fork3.lock();
                    p4.run();
                }
                else
                {
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
            else
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {

                }
            }
            //endregion
//region Philosopher 5 is trying to eat
            if(!fork5.isLocked())
            {
                fork5.lock();
                if(!fork4.isLocked())
                {
                    fork4.lock();
                    p5.run();
                }
                else
                {
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
            else
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {

                }
            }
            //endregion

        }
    }

}
