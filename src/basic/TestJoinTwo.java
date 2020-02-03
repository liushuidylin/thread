package basic;

/**
 * @Author: duyilin@golaxy.cn
 * @Date: Created in 14:45 2020/1/26
 */
public class TestJoinTwo  {
    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1开始跑了");
                for (;;) {
                }
            }
        });

        final Thread mainThread = Thread.currentThread();

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //中断主线程
                mainThread.interrupt();
            }
        });

        threadOne.start();
        threadTwo.start();
        try {
            //等待线程1执行结束
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("主线程"+ e);
        }
    }
}
