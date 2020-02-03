package basic;

/**
 * @Author: duyilin@golaxy.cn
 * @Date: Created in 14:23 2020/1/26
 *
 * 主线程里面启动两个子线程，然后分别调用它们的join()方法，
 * 主线程调用threadOne.join()方法后被阻塞，等待thraedOne执行完毕后返回
 * 主线程调用threadTwo.join()方法后被阻塞，等待threadTwo执行完毕后返回
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1完成");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2完成");
            }
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("等待所有的线程完成");

        threadOne.join();
        threadTwo.join();

        System.out.println("所有的线程完成");
    }
}
