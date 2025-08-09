package task_01;

public class Task1 {

    public static void main(String[] args) {

        // Два способа создания потока
        // 1. Наследование от класса Thread
        // 2. Реализация интерфейса Runnable

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        // Это не порождает новые потоки
        // Мы получаем последовательное выполнение методов в текущем потоке
//        myThread1.run();
//        myThread2.run();

        // При создании наследования вызываем метод start()
        // Метод start создает новый поток, в котором будет выполнен
        // набор инструкций, прописанных в методе run()
        myThread1.start();


        Thread thread = new Thread(myThread2);
        // Для того чтобы сделать поток демон-потоком
        thread.setDaemon(true); // можно только до старта
        thread.start();

        /*
        При имплементации:
        1. Создаем объект класса Thread
        При создании объекта в конструктор мы должны передать реализацию
        интерфейса Runnable (мы передадим объект нашего класса, имплементирующего Runnable)
        У созданного объекта Thread вызывает метод start()
         */

        // Main-поток
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
