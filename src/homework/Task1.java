package homework;

public class Task1 {

    private static int counter;

    public static synchronized void incrementCounter() {
        counter++;
    }

    private static void singleThreadSolution() {

        MyThread thread = new MyThread(1, 2000000);

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter value with single thread " + counter);
    }

    private static void twoThreadSolution() {

        MyThread thread1 = new MyThread(1, 1000000);
        MyThread thread2 = new MyThread(1000001, 2000000);


        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter value with two threads " + counter);

    }

    public static void main(String[] args) {

        singleThreadSolution();
        counter = 0;
        twoThreadSolution();
    }
}
