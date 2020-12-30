//Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
// (порядок – ABСABСABС). Используйте wait/notify/notifyAll.


public class ABC {
    private final Object obj = new Object();
    private volatile char currentLetter = 'A';
    private static final int num=5;

    public static void main(String[] args) {
        ABC abc = new ABC();
        Thread thread1 = new Thread(() -> {
            abc.printA();
        });
        Thread thread2 = new Thread(() -> {
            abc.printB();
        });
        Thread thread3=new Thread(()-> {
            abc.printC();
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }


    public void printA() {
        synchronized (obj) {
            try {
                for (int i = 0; i < num; i++) {
                    while (currentLetter != 'A') {
                        obj.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (obj) {
            try {
                for (int i = 0; i < num; i++) {
                    while (currentLetter != 'B') {
                        obj.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (obj) {
            try {
                for (int i = 0; i < num; i++) {
                    while (currentLetter != 'C') {
                        obj.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}