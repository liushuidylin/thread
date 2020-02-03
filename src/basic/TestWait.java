package basic;

/**
 * @Author: duyilin@golaxy.cn
 * @Date: Created in 15:06 2020/1/26
 */
public class TestWait {
    private static volatile Object resoureA = new Object();
    private static volatile Object resoureB = new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resoureA){
                        System.out.println("A得到A锁");
                        synchronized (resoureB){
                            System.out.println("A得到B锁");
                            System.out.println("A释放A锁");
                            resoureA.wait();
//                            resoureB.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    Thread.sleep(1000);
                    synchronized (resoureA){
                        System.out.println("B得到A锁");
                        System.out.println("B尝试得到B锁");
                        synchronized (resoureB){
                            System.out.println("B得到B锁");
                            System.out.println("B释放A锁");
                            resoureA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println("主线程挂了");
    }
}
