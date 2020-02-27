public class Philosopher implements Runnable {
    @Override
    public void run() {
        ForkCheck();
    }

    public void ForkCheck(){
        System.out.println(Thread.currentThread().getName() + " Is eating");
    }
}
