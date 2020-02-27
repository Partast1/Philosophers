import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadHandler {
    static final int MAX_T = 3;

     ReentrantLock fork1 = new ReentrantLock();
     ReentrantLock fork2 = new ReentrantLock();
     ReentrantLock fork3 = new ReentrantLock();
     ReentrantLock fork4 = new ReentrantLock();
     ReentrantLock fork5 = new ReentrantLock();

     Runnable p1 = new Philosopher();
     Runnable p2 = new Philosopher();
     Runnable p3 = new Philosopher();
     Runnable p4 = new Philosopher();
     Runnable p5 = new Philosopher();
    public void Threads()
    {
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
}
